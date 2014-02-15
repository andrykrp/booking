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

    @Override
    public InputStream getHotelList() {
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
        return loadSource(uri);
    }

    @Override
    public InputStream getRoomsRates() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
