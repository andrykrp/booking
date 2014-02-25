package org.octocode.booking.parser.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.octocode.booking.model.Room;
import org.octocode.booking.parser.expedia.dto.room.RoomDetails;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Guskov
 */

@Component
public class ExpediaRoomMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(RoomDetails.class, Room.class)
//                .field("bedTypeWrapper.bedType.description", "bedType")
                .byDefault()
                .register();
    }
}
