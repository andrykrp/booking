package org.octocode.booking.client;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @author Dmitriy Guskov
 */

@Component
public class ExpediaClient extends RestClient {
    private static final Logger LOGGER = Logger.getLogger(ExpediaClient.class);
    @Value("${expedia.url}")
    public String service;
    @Value("${expedia.apiVersion}")
    public String version;
    private String hotelListContext = "list";
    private String roomListContext = "avail";
    private String roomImages = "roomImages";
    @Value("${expedia.cid}")
    public String cid;
    @Value("${expedia.apiKey}")
    public String apikey;
    @Value("${expedia.secret}")
    public String secret;

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

    private URI getBaseURL(String requestContext) {
        try {
            return new URIBuilder(service + version  + "/" + requestContext)
                    .addParameter("apikey", apikey)
                    .addParameter("cid", cid)
                    .addParameter("locale", "RU")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream getHotelList(Map<String, String> params) {
        URI uri = null;
        try {
            uri = new URIBuilder(getBaseURL(hotelListContext))
                    .addParameter("sig", createSignature())
                    .addParameter("destinationString", params.get("destinationString"))
                    .addParameter("countryCode", params.get("countryCode"))
                    .addParameter("arrivalDate", params.get("arrivalDate"))
                    .addParameter("departureDate", params.get("departureDate"))
                    .addParameter("supplierCacheTolerance", "MED_ENHANCED")
                    .addParameter("room1", "1,3")
                    .addParameter("numberOfResults", "200")
                    .addParameter("customerIpAddress", "13.45.2.6")
                    .addParameter("options", "HOTEL_SUMMARY,DEEP_LINKS")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("URL = " + uri.toString());
        return loadSource(uri);
    }

    public InputStream getNextHotelList(Map<String, String> pagingParams) {
        URIBuilder uriBuilder = new URIBuilder(getBaseURL(hotelListContext));
        for (Map.Entry entry : pagingParams.entrySet()) {
            uriBuilder.addParameter((String) entry.getKey(), (String) entry.getValue());
        }
        URI uri = null;
        try {
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return loadSource(uri);
    }

    @Override
    public InputStream getRoomsRates(Map<String, String> params) {
        URI uri = null;
        try {
            uri = new URIBuilder(getBaseURL(roomListContext))
                    .addParameter("currencyCode", "USD")
                    .addParameter("hotelId", params.get("hotelId"))
                    .addParameter("arrivalDate", params.get("arrivalDate"))
                    .addParameter("departureDate", params.get("departureDate"))
                    .addParameter("room1", params.get("room1"))
                    .addParameter("includeDetails", "true")
//                    .addParameter("includeRoomImages", "true")
                    .addParameter("options", "ROOM_AMENITIES")
                    .addParameter("minorRev", "26")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return loadSource(uri);
    }
}
