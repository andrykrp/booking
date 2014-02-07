package org.octocode.booking.parser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * @author Dmitriy Guskov
 */
public class AbstractParser {
    public void sendRequest(URI url) {
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
