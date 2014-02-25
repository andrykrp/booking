package org.octocode.booking.parser.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.octocode.booking.model.Hotel;
import org.octocode.booking.parser.expedia.dto.HotelData;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Guskov
 */

@Component
public class ExpediaHotelMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(HotelData.class, Hotel.class)
                .byDefault().register();
    }
}
