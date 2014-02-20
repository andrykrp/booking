package org.octocode.booking.parser.laterooms;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import org.octocode.booking.client.LateroomsClient;
import org.octocode.booking.client.RestClient;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.Parser;
import org.octocode.booking.parser.laterooms.dto.GeoSearchData;
import org.octocode.booking.parser.laterooms.dto.HotelData;
import org.octocode.booking.parser.mapper.LateroomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class LateRoomsParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(LateRoomsParser.class);
    @Autowired
    private LateroomsMapper lateroomsMapper;
    //@Autowired
    //private XmlMapper objectMapper;
    @Autowired
    @Qualifier("lateroomsClient")
    private RestClient client;

    GeoSearchData entry;

    public List<Hotel> parseHotelList(String latitude, String longitude) {
        try {
            ((LateroomsClient)client).setLocation(latitude, longitude);
        }
        catch (Exception e) {}
        return parseHotelList();
    }

    @Override
    public List<Hotel> parseHotelList() {
        List<Hotel> hotels = new ArrayList<>();
        try {
            InputStream sourceStream = client.getHotelList();
            LOGGER.info("Input source obtained from client");
            XmlMapper xmlMapper = new XmlMapper();
            LOGGER.info("XML mapper built");
            entry = xmlMapper.readValue(sourceStream, GeoSearchData.class);
            LOGGER.info("Geo search data is READ"+entry.getNoNamespaceSchemaLocation());
            for (HotelData data : entry.getHotel()) {
                hotels.add(lateroomsMapper.map(data, Hotel.class));
            }
            LOGGER.info("Hotel data is mapped:"+hotels.size());
        } catch (Exception e) {
            LOGGER.info("Laterooms response parsing exception", e);
            throw new RuntimeException("Laterooms response parsing exception:", e);
        }
        return hotels;
    }
}
