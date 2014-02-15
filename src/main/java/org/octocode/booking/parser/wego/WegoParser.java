package org.octocode.booking.parser.wego;

import org.apache.http.client.utils.URIBuilder;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.RestParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Dmitriy Guskov
 */

@Component
public class WegoParser extends RestParser {
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
    }

    @Override
    public List<Hotel> parse(InputStream stream) {
        return null;
    }
}
