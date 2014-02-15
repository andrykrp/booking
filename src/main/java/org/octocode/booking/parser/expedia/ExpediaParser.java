package org.octocode.booking.parser.expedia;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.RestParser;
import org.octocode.booking.parser.expedia.dto.ExpediaHotel;
import org.octocode.booking.parser.expedia.dto.HotelData;
import org.octocode.booking.parser.mapper.ExpediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Guskov
 */
@Component
public class ExpediaParser extends RestParser {
    private static final Logger LOGGER = Logger.getLogger(ExpediaParser.class);
    @Value("${expedia.url}")
    public String service;
    @Value("${expedia.apiVersion}")
    public String version;
    public String method = "list";
    public String geolocationMethod = "geoSearch";
    @Value("${expedia.cid}")
    public String cid;
    @Value("${expedia.apiKey}")
    public String apikey;
    @Value("${expedia.secret}")
    public String secret;
    @Autowired
    private ExpediaMapper expediaMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public List<Hotel> getByCityName() {
        URI uri = null;
        try {
            uri = new URIBuilder(service + version  + "/" + method)
                    .addParameter("apikey", apikey)
                    .addParameter("sig", createSignature())
                    .addParameter("cid", cid)
                    .addParameter("destinationString", "Rome")
                    .addParameter("countryCode", "IT")
                    .addParameter("arrivalDate", "02/21/2014")
                    .addParameter("departureDate", "02/27/2014")
                    .addParameter("supplierCacheTolerance", "MED_ENHANCED")
                    .addParameter("room1", "1,3")
                    .addParameter("locale", "RU")
                    .addParameter("customerIpAddress", "13.45.2.6")
                    .addParameter("customerSessionId", "0ABAAA76-F84C-5A91-4422-0C7E0A693B19")
                    .addParameter("numberOfResults", "200")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("URL = " + uri.toString());
        InputStream sourceStream = loadSource(uri);
        return parse(sourceStream);
    }

    public String getHotelList() throws URISyntaxException {
        URI uri = new URIBuilder(service + version + "/" + method)
                .addParameter("apikey", apikey)
                .addParameter("sig", createSignature())
                .addParameter("cid", cid)
                .addParameter("minorRev","[x]")
                .addParameter("customerUserAgent","")
                .addParameter("customerIpAddress","[xxx]")
                .addParameter("locale", "ru")
                .addParameter("currencyCode", "USD")
                .addParameter("hotelIdList", "").build();
        return uri.toString();
    }

    private String createSignature() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // should never happen
        }
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        String input = apikey + secret + timeInSeconds;
        md.update(input.getBytes());
        return String.format("%032x", new BigInteger(1, md.digest()));
    }

    public List<Hotel> parse(InputStream response) {
//        InputStream readStream = new BufferedInputStream(response);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(readStream));
//        String line;
//        try {
//            while ((line = bufferedReader.readLine()) != null) {
//                LOGGER.debug(line);
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            throw new RuntimeException("Expedia response reading error", e);
//        }

        List<Hotel> hotels = new ArrayList<>();
        try {
            objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

            ExpediaHotel expediaHotel = objectMapper.readValue(response, ExpediaHotel.class);
            for (HotelData data : expediaHotel.getHotelListWrapper().getHotelList()) {
                hotels.add(expediaMapper.map(data, Hotel.class));
            }
        } catch (Exception e) {
            throw new RuntimeException("Expedia response parsing exception", e);
        }
        return hotels;
    }
}
