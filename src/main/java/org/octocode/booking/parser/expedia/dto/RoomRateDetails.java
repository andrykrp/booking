package org.octocode.booking.parser.expedia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomRateDetails {
    private Long roomTypeCode;
    private Long rateCode;
    private Integer currentAllotment;
    private Integer maxRoomOccupancy;
    private Integer quotedRoomOccupancy;
    private String roomDescription;
    private String promoDescription;
    private String rateKey;

    public Long getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(Long roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public Long getRateCode() {
        return rateCode;
    }

    public void setRateCode(Long rateCode) {
        this.rateCode = rateCode;
    }

    public Integer getMaxRoomOccupancy() {
        return maxRoomOccupancy;
    }

    public void setMaxRoomOccupancy(Integer maxRoomOccupancy) {
        this.maxRoomOccupancy = maxRoomOccupancy;
    }

    public Integer getQuotedRoomOccupancy() {
        return quotedRoomOccupancy;
    }

    public void setQuotedRoomOccupancy(Integer quotedRoomOccupancy) {
        this.quotedRoomOccupancy = quotedRoomOccupancy;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRateKey() {
        return rateKey;
    }

    public void setRateKey(String rateKey) {
        this.rateKey = rateKey;
    }

    public Integer getCurrentAllotment() {
        return currentAllotment;
    }

    public void setCurrentAllotment(Integer currentAllotment) {
        this.currentAllotment = currentAllotment;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }
}
