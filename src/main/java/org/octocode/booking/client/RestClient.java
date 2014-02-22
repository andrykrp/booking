package org.octocode.booking.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/**
 * @author Dmitriy Guskov
 */

public abstract class RestClient implements Client {
    private static final Logger LOGGER = Logger.getLogger(RestClient.class);

    public InputStream loadSource(URI url) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        LOGGER.debug(httpget.getRequestLine());

        HttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
            LOGGER.debug(response.getStatusLine());
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();

                return new ByteArrayInputStream(EntityUtils.toByteArray(entity));
            }
            throw new RuntimeException("Request failed with code: " + response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    public abstract InputStream getHotelList(Map<String, String> params);

    public abstract InputStream getRoomsRates(Map<String, String> params);
}
