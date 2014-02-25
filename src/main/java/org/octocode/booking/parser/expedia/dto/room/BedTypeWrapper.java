package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BedTypeWrapper {
    @JsonProperty("BedType")
    private List<BedType> bedType;

    public List<BedType> getBedType() {
        return bedType;
    }

    public void setBedType(List<BedType> bedType) {
        this.bedType = bedType;
    }
}
