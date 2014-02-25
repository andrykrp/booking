package org.octocode.booking.client;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author Dmitriy Guskov
 */

@Component
public class LateroomsClient extends RestClient {
    private static final Logger LOGGER = Logger.getLogger(LateroomsClient.class);
    @Value("${laterooms.url}")//coordinatesCheck.url
    private String url;
    @Value("${laterooms.aid}")
    private String aid;

    String latitude = "27.2578957";
    String longitude = "33.8116067";

    public void setLocation(String latit, String longit) {
        latitude = latit;
        longitude = longit;
    }

    public InputStream getHotelRates(String hotelId, String date, String nights) {
        URI uri = null;
        try {
            uri = new URIBuilder(url)
                    .addParameter("aid", aid)
                    .addParameter("rtype", "7")
                    .addParameter("hids", hotelId)
                    .addParameter("sdate", date)
                    .addParameter("nights", nights)
                    .build();
            LOGGER.info("URL built = " + uri.toString());
        } catch (URISyntaxException e) {
            LOGGER.info("URL building exception: URL=" + uri.toString() + ", exception: "+e);
            throw new RuntimeException(e);
        }

        LOGGER.info("URL = " + uri.toString());
        return loadSource(uri);
    }
    @Override
    public InputStream getHotelList(Map<String, String> params) {
        URI uri = null;
        try {
            uri = new URIBuilder(url)
                    .addParameter("aid", aid)
                    .addParameter("rtype", "6")
                    .addParameter("geolon", longitude)
                    .addParameter("geolat", latitude)
                    .build();
            LOGGER.info("URL built = " + uri.toString());
        } catch (URISyntaxException e) {
            LOGGER.info("URL building exception: URL=" + uri.toString() + ", exception: "+e);
            throw new RuntimeException(e);
        }

        LOGGER.info("URL = " + uri.toString());
        return loadSource(uri);
    }

    @Override
    public InputStream getRoomsRates(Map<String, String> params) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
