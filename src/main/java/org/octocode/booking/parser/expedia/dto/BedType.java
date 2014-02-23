package org.octocode.booking.parser.expedia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BedType {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
