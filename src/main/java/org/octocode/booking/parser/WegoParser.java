package org.octocode.booking.parser;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Dmitriy Guskov
 */

@Component
public class WegoParser extends AbstractParser {
    @Value("${wego.url}")
    private String url;
    @Value("${wego.apiKey}")
    private String apiKey;
    @Value("${wego.tsCode}")
    private String tsCode;
    private String locationPath = "/locations/search";

    public void getHotelsList() throws URISyntaxException {
        URI uri = new URIBuilder(url + locationPath)
                .addParameter("q", "orenburg")
                .addParameter("api_key", apiKey)
                .addParameter("ts_code", tsCode)
                .addParameter("user_ip", "direct")
                .build();
        sendRequest(uri);
    }


}
