package org.octocode.booking.parser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.octocode.booking.model.Hotel;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Guskov
 */
public abstract class AbstractParser {

    public List<Hotel> sendRequest(URI url) {
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
        }

        HttpEntity entity = response.getEntity();
        // Print the response
        System.out.println(response.getStatusLine());

        List<Hotel> hotels = new ArrayList<>();
        if (entity != null) {
            try {
                hotels = parseResponse(entity.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // shut down the connection manager to free up system resources.
        httpclient.getConnectionManager().shutdown();

        return hotels;
    }

    protected abstract List<Hotel> parseResponse(InputStream response);
}
