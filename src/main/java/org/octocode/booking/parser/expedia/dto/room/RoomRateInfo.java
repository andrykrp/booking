package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.octocode.booking.parser.expedia.dto.common.RateInfo;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomRateInfo {
    @JsonProperty("ChargeableRateInfo")
    private RateInfo roomRateInfo;

    public RateInfo getRoomRateInfo() {
        return roomRateInfo;
    }

    public void setRoomRateInfo(RateInfo roomRateInfo) {
        this.roomRateInfo = roomRateInfo;
    }
}
