package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomAmenity {
    @JsonProperty("@amenityId")
    private String id;
    @JsonProperty("amenity")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
