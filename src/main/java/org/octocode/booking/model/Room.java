package org.octocode.booking.model;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */

public class Room {
    private String propertyId;
    private String rateCode;
    private String roomTypeCode;
    private String roomTypeName;
    private String roomTypeDescription;
    private String smokingPreferences;
    private String deepLink;
    private String bedType;
    private String adults;
    private String children;
    private String dinner;
    private String breakfast;
    private String minNights = "1";
    private String roomsAvailable;
    private Rate rate;
    private List<Amenity> amenities;
    private String cancellationPolicy;
    private String cancellationDays;
    private String cancellationHours;
    private String lateCancellationCharge;
    private String roomTerms;

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

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
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

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getMinNights() {
        return minNights;
    }

    public void setMinNights(String minNights) {
        this.minNights = minNights;
    }

    public String getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(String roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public String getCancellationDays() {
        return cancellationDays;
    }

    public void setCancellationDays(String cancellationDays) {
        this.cancellationDays = cancellationDays;
    }

    public String getCancellationHours() {
        return cancellationHours;
    }

    public void setCancellationHours(String cancellationHours) {
        this.cancellationHours = cancellationHours;
    }

    public String getLateCancellationCharge() {
        return lateCancellationCharge;
    }

    public void setLateCancellationCharge(String lateCancellationCharge) {
        this.lateCancellationCharge = lateCancellationCharge;
    }

    public String getRoomTerms() {
        return roomTerms;
    }

    public void setRoomTerms(String roomTerms) {
        this.roomTerms = roomTerms;
    }
}
