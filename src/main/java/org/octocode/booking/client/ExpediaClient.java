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
    public String method = "list";
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

    private URI getBaseURL() {
        try {
            return new URIBuilder(service + version  + "/" + method)
                    .addParameter("apikey", apikey)
                    .addParameter("cid", cid)
                    .addParameter("locale", "RU")
                    .addParameter("customerIpAddress", "13.45.2.6")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream getHotelList(Map<String, String> params) {
        URI uri = null;
        try {
            uri = new URIBuilder(getBaseURL())
                    .addParameter("sig", createSignature())
                    .addParameter("destinationString", params.get("destinationString"))
                    .addParameter("countryCode", params.get("countryCode"))
                    .addParameter("arrivalDate", params.get("arrivalDate"))
                    .addParameter("departureDate", params.get("departureDate"))
                    .addParameter("supplierCacheTolerance", "MED_ENHANCED")
                    .addParameter("room1", "1,3")
                    .addParameter("numberOfResults", "200")
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("URL = " + uri.toString());
        return loadSource(uri);
    }

    public InputStream getNextHotelList(Map<String, String> pagingParams) {
        URIBuilder uriBuilder = new URIBuilder(getBaseURL());
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
    public InputStream getRoomsRates() {
        return null;
    }
}
