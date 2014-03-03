package org.octocode.booking.parser.laterooms;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import org.octocode.booking.client.LateroomsClient;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.model.Room;
import org.octocode.booking.parser.Parser;
import org.octocode.booking.parser.laterooms.dto.*;
import org.octocode.booking.parser.mapper.LateroomsMapper;
import org.octocode.booking.parser.mapper.LateroomsRoomMapper;
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
    @Autowired
    private LateroomsRoomMapper lateroomsRoomMapper;
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

    public List<Room> getRoomRates(Map<String, String> requestParams)
    {
        HotelRatesData hotelRates = null;
        List<RoomDetails> roomDetailsList = null;
        List<Room> roomsList = new ArrayList<>();
        try {
            InputStream sourceStream = client.getHotelRates(requestParams);
            LOGGER.info("Input source obtained from client");
            XmlMapper xmlMapper = new XmlMapper();
            LOGGER.info("XML mapper built");
            rates = xmlMapper.readValue(sourceStream, RatesData.class);
            LOGGER.info("Rates search data is READ:");//+rates.getHotel().size());
            if (!rates.getHotel().isEmpty()) {
                hotelRates = rates.getHotel().get(0);
                roomDetailsList = hotelRates.getRoomDetails();
                for (RoomDetails roomDetails : roomDetailsList) {
                    roomDetails.updateRate();
                    roomsList.add(lateroomsRoomMapper.map(roomDetails, Room.class));
                }
            }
            LOGGER.info("Hotel rates quantity retrieved:"+rates.getHotel().size());
        } catch (Exception e) {
            LOGGER.info("Laterooms response parsing exception", e);
            throw new RuntimeException("Laterooms response parsing exception:", e);
        }
        return roomsList;
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
