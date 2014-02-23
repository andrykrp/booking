package org.octocode.booking.parser.expedia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Dmitriy Guskov
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("HotelListResponse")
public class ExpediaHotelList {
    @JsonProperty("customerSessionId")
    private String sessionId;
    private String cacheKey;
    private String cacheLocation;
    @JsonProperty("moreResultsAvailable")
    private Boolean hasMoreResults;
    @JsonProperty("HotelList")
    private HotelListWrapper hotelListWrapper;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public String getCacheLocation() {
        return cacheLocation;
    }

    public void setCacheLocation(String cacheLocation) {
        this.cacheLocation = cacheLocation;
    }

    public void setHotelListWrapper(HotelListWrapper hotelListWrapper) {
        this.hotelListWrapper = hotelListWrapper;
    }

    public HotelListWrapper getHotelListWrapper() {
        return hotelListWrapper;
    }

    public Boolean getHasMoreResults() {
        return hasMoreResults;
    }

    public void setHasMoreResults(Boolean hasMoreResults) {
        this.hasMoreResults = hasMoreResults;
    }
}
