package org.octocode.booking.parser.expedia;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.octocode.booking.client.RestClient;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.Parser;
import org.octocode.booking.parser.expedia.dto.ExpediaHotel;
import org.octocode.booking.parser.expedia.dto.HotelData;
import org.octocode.booking.parser.mapper.ExpediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    private RestClient client;

    public List<Hotel> parseHotelList() {
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

            InputStream sourceStream = client.getHotelList();
            ExpediaHotel expediaHotel = objectMapper.readValue(sourceStream, ExpediaHotel.class);
            for (HotelData data : expediaHotel.getHotelListWrapper().getHotelList()) {
                hotels.add(expediaMapper.map(data, Hotel.class));
            }
        } catch (Exception e) {
            throw new RuntimeException("Expedia response parsing exception", e);
        }
        return hotels;
    }
}
