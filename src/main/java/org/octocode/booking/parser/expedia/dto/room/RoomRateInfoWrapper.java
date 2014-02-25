package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomRateInfoWrapper {
    @JsonProperty("RateInfo")
    private RoomRateInfo roomRateInfo;

    public RoomRateInfo getRoomRateInfo() {
        return roomRateInfo;
    }

    public void setRoomRateInfo(RoomRateInfo roomRateInfo) {
        this.roomRateInfo = roomRateInfo;
    }
}
