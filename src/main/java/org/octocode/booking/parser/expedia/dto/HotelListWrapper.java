package org.octocode.booking.parser.expedia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelListWrapper {
    @JsonProperty("@size")
    private Integer size;
    @JsonProperty("@activePropertyCount")
    private Integer activePropertyCount;
    @JsonProperty("HotelSummary")
    private List<HotelData> hotelList;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getActivePropertyCount() {
        return activePropertyCount;
    }

    public void setActivePropertyCount(Integer activePropertyCount) {
        this.activePropertyCount = activePropertyCount;
    }

    public List<HotelData> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<HotelData> hotelList) {
        this.hotelList = hotelList;
    }
}
