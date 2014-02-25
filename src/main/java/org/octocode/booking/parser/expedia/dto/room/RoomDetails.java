package org.octocode.booking.parser.expedia.dto.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDetails {
    private String propertyId;
    private String rateCode;
    private String roomTypeCode;
    private String roomTypeDescription;
    @JsonProperty("BedTypes")
    private BedTypeWrapper bedTypeWrapper;
    private String smokingPreferences;
    private String deepLink;
    @JsonProperty("RateInfos")
    private RoomRateInfoWrapper roomRateInfoWrapper;
    @JsonProperty("RoomType")
    private RoomType roomType;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public void setRoomTypeDescription(String roomTypeDescription) {
        this.roomTypeDescription = roomTypeDescription;
    }

    public BedTypeWrapper getBedTypeWrapper() {
        return bedTypeWrapper;
    }

    public void setBedTypeWrapper(BedTypeWrapper bedTypeWrapper) {
        this.bedTypeWrapper = bedTypeWrapper;
    }

    public String getSmokingPreferences() {
        return smokingPreferences;
    }

    public void setSmokingPreferences(String smokingPreferences) {
        this.smokingPreferences = smokingPreferences;
    }

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    public RoomRateInfoWrapper getRoomRateInfoWrapper() {
        return roomRateInfoWrapper;
    }

    public void setRoomRateInfoWrapper(RoomRateInfoWrapper roomRateInfoWrapper) {
        this.roomRateInfoWrapper = roomRateInfoWrapper;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
