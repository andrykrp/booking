package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomAmenitiesWrapper {
    @JsonProperty("RoomAmenity")
    private List<RoomAmenity> amenities;

    public List<RoomAmenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<RoomAmenity> amenities) {
        this.amenities = amenities;
    }
}
