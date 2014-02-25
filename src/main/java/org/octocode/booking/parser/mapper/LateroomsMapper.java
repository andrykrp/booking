package org.octocode.booking.parser.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.laterooms.dto.HotelData;
import org.springframework.stereotype.Component;

@Component
public class LateroomsMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(HotelData.class, Hotel.class)
                .field("hotel_ref", "hotelId")
                .field("hotel_name", "name")
                .field("geo_code['lat']", "latitude")
                .field("geo_code['long']", "longitude")
                .byDefault().register();
    }
}
