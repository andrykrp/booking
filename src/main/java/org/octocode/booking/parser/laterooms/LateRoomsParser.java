package org.octocode.booking.parser.laterooms;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import org.octocode.booking.client.LateroomsClient;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.Parser;
import org.octocode.booking.parser.laterooms.dto.GeoSearchData;
import org.octocode.booking.parser.laterooms.dto.HotelData;
import org.octocode.booking.parser.laterooms.dto.HotelRatesData;
import org.octocode.booking.parser.laterooms.dto.RatesData;
import org.octocode.booking.parser.mapper.LateroomsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LateRoomsParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(LateRoomsParser.class);
    @Autowired
    private LateroomsMapper lateroomsMapper;
    //@Autowired
    //private XmlMapper objectMapper;
    @Autowired
    //@Qualifier("lateroomsClient")
    private LateroomsClient client;

    GeoSearchData entry;
    RatesData rates;

    public List<Hotel> parseHotelList(String latitude, String longitude) {
        try {
            client.setLocation(latitude, longitude);
        }
        catch (Exception e) {}
        //TODO
        return parseHotelList(null);
    }

    public HotelRatesData getRatesForHotel(String hotelId, String startDate, String nights)
    {
        HotelRatesData hotelRates = null;
        try {
            InputStream sourceStream = client.getHotelRates(hotelId, startDate, nights);
            LOGGER.info("Input source obtained from client");
            XmlMapper xmlMapper = new XmlMapper();
            LOGGER.info("XML mapper built");
            rates = xmlMapper.readValue(sourceStream, RatesData.class);
            LOGGER.info("Rates search data is READ"+entry.getNoNamespaceSchemaLocation());
            if (!rates.getHotel().isEmpty()) {
                hotelRates = rates.getHotel().get(0);
            }
            LOGGER.info("Hotel rates quantity retrieved:"+hotelRates.getRoom().size());
        } catch (Exception e) {
            LOGGER.info("Laterooms response parsing exception", e);
            throw new RuntimeException("Laterooms response parsing exception:", e);
        }
        return hotelRates;
    }

    @Override
    public List<Hotel> parseHotelList(Map<String, String> params) {
        List<Hotel> hotels = new ArrayList<>();
        try {
            //TODO
            InputStream sourceStream = client.getHotelList(null);
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
