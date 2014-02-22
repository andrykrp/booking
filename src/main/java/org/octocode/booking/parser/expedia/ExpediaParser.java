package org.octocode.booking.parser.expedia;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.octocode.booking.client.ExpediaClient;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.Parser;
import org.octocode.booking.parser.expedia.dto.ExpediaHotel;
import org.octocode.booking.parser.expedia.dto.HotelData;
import org.octocode.booking.parser.mapper.ExpediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmitriy Guskov
 */
@Component
public class ExpediaParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(ExpediaParser.class);
    @Autowired
    private ExpediaMapper expediaMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ExpediaClient client;

    public List<Hotel> parseHotelList(Map<String, String> requestParams) {
//        InputStream readStream = new BufferedInputStream(response);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(readStream));
//        String line;
//        try {
//            while ((line = bufferedReader.readLine()) != null) {
//                LOGGER.debug(line);
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            throw new RuntimeException("Expedia response reading error", e);
//        }

        List<Hotel> hotels = new ArrayList<>();
        try {
            objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

            InputStream sourceStream = client.getHotelList(requestParams);
            ExpediaHotel expediaHotel = objectMapper.readValue(sourceStream, ExpediaHotel.class);
            for (HotelData data : expediaHotel.getHotelListWrapper().getHotelList()) {
                hotels.add(expediaMapper.map(data, Hotel.class));
            }
            if (expediaHotel.getHasMoreResults()) {
                hotels.addAll(parseNextHotelList(getPagingParameters(expediaHotel)));
            }
        } catch (Exception e) {
            throw new RuntimeException("Expedia response parsing exception", e);
        }
        return hotels;
    }

    private List<Hotel> parseNextHotelList(Map<String, String> pagingParams) throws IOException {
        List<Hotel> hotels = new ArrayList<>();
        InputStream sourceStream = client.getNextHotelList(pagingParams);
        ExpediaHotel expediaHotel = objectMapper.readValue(sourceStream, ExpediaHotel.class);
        for (HotelData data : expediaHotel.getHotelListWrapper().getHotelList()) {
            hotels.add(expediaMapper.map(data, Hotel.class));
        }
        if (expediaHotel.getHasMoreResults()) {
            hotels.addAll(parseNextHotelList(getPagingParameters(expediaHotel)));
        }

        return hotels;
    }

    private Map<String, String> getPagingParameters(ExpediaHotel hotelWrapper) {
        Map<String, String> pagingParams = new HashMap<>();
        pagingParams.put("customerSessionId", hotelWrapper.getSessionId());
        pagingParams.put("cacheKey", hotelWrapper.getCacheKey());
        pagingParams.put("cacheLocation", hotelWrapper.getCacheLocation());

        return pagingParams;
    }
}