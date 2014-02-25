package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomType {
    @JsonProperty("@roomCode")
    private String roomCode;
    private String description;
    @JsonProperty("descriptionLong")
    private String fullDescription;
    @JsonProperty("roomAmenities")
    private RoomAmenitiesWrapper amenitiesWrapper;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public RoomAmenitiesWrapper getAmenitiesWrapper() {
        return amenitiesWrapper;
    }

    public void setAmenitiesWrapper(RoomAmenitiesWrapper amenitiesWrapper) {
        this.amenitiesWrapper = amenitiesWrapper;
    }
}
