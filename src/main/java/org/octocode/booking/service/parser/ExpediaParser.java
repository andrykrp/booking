package org.octocode.booking.service.parser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Dmitriy Guskov
 */
@Component
public class ExpediaParser {
    @Value("${expedia.url}")
    public String service;
    @Value("${expedia.apiVersion}")
    public String version;
    public String method = "list";
    public String geolocationMethod = "geoSearch";
    public String hotelId = "201252";
    @Value("${expedia.cid}")
    public String cid;
    @Value("${expedia.apiKey}")
    public String apikey;
    @Value("${expedia.secret}")
    public String secret;

    public String getGeoLocation() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // should never happen
        }
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        String input = apikey + secret + timeInSeconds;
        md.update(input.getBytes());
        String sig = String.format("%032x", new BigInteger(1, md.digest()));

        String url = service + version  + "/" + geolocationMethod  + "?apikey=" + apikey
                + "&sig=" + sig + "&cid=" + cid + "&destinationString=Rome&countryCode=IT";
        System.out.println("URL = " + url);
        return url;
    }

    public String getHotelList() throws URISyntaxException {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // should never happen
        }
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        String input = apikey + secret + timeInSeconds;
        md.update(input.getBytes());
        String sig = String.format("%032x", new BigInteger(1, md.digest()));

        URI uri = new URIBuilder(service + version + "/" + method)
                .addParameter("apikey", apikey)
                .addParameter("sig", sig)
                .addParameter("cid", cid)
                .addParameter("minorRev","[x]")
                .addParameter("customerUserAgent","")
                .addParameter("customerIpAddress","[xxx]")
                .addParameter("locale", "ru_RU")
                .addParameter("currencyCode", "USD")
                .addParameter("hotelIdList", hotelId).build();

        System.out.println("URL = " + uri.toString());
        return uri.toString();
    }

    public void sendRequest(String url) {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        // Create an HTTP GET request
        HttpGet httpget = new HttpGet(url);

        // Execute the request
        httpget.getRequestLine();
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        HttpEntity entity = response.getEntity();
        // Print the response
        System.out.println(response.getStatusLine());

        if (entity != null) {
            try {
                InputStream inputStream = entity.getContent();
                // Process the response
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // shut down the connection manager to free up system resources.
        httpclient.getConnectionManager().shutdown();
    }
}
