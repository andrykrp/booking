package org.octocode.booking.parser.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.octocode.booking.model.Room;
import org.octocode.booking.parser.laterooms.dto.RoomDetails;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Guskov
 */

@Component
public class LateroomsRoomMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(RoomDetails.class, Room.class)
                .field("ref", "propertyId")
                .field("type_description", "roomTypeName")
                .field("description", "roomTypeDescription")
                .field("type", "roomTypeCode")
                .field("rate.roomtype", "rate.name")
                .field("rate.numeric_price", "rate.price")
                .field("rate.requested_currency", "rate.currency")
                .field("cancellationDays.stringValue", "cancellationDays")
                .field("cancellationHours.stringValue", "cancellationHours")
                .byDefault()
                .register();
    }
}
