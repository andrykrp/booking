package org.octocode.booking.parser.laterooms;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import org.octocode.booking.client.RestClient;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.Parser;
import org.octocode.booking.parser.laterooms.dto.GeoSearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class LateRoomsParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(LateRoomsParser.class);
    //@Autowired
    //private ExpediaMapper lateroomsMapper;
    //@Autowired
    //private XmlMapper objectMapper;
    @Autowired
    @Qualifier("lateroomsClient")
    private RestClient client;

    @Override
    public List<Hotel> parseHotelList() {
        try {
            InputStream sourceStream = client.getHotelList();
            LOGGER.info("Input source obtained from client");
            XmlMapper xmlMapper = new XmlMapper();
            LOGGER.info("XML mapper built");
            GeoSearchData entry = xmlMapper.readValue(sourceStream, GeoSearchData.class);
            LOGGER.info("Geo search data is READ");
        } catch (Exception e) {
            LOGGER.info("Laterooms response parsing exception", e);
            throw new RuntimeException("Laterooms response parsing exception:", e);
        }
        return null;
    }
}
