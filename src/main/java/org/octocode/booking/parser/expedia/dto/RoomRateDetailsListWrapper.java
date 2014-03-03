package org.octocode.booking.parser.expedia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomRateDetailsListWrapper {
    @JsonProperty("RoomRateDetails")
    private RoomRateDetails roomRateDetails;

    public RoomRateDetails getRoomRateDetails() {
        return roomRateDetails;
    }

    public void setRoomRateDetails(RoomRateDetails roomRateDetails) {
        this.roomRateDetails = roomRateDetails;
    }
}
