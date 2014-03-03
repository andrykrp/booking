package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

//import org.octocode.booking.parser.laterooms.dto.TagValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDetails {
    private String ref;
    private String typedescription;
    private String type_description;
    private String type;
    private String typename;
    private String sleeps;
    private String breakfast;
    private String dinner;
    private String adults;
    private String children;
    private String description;
    private String alternate_description;
    private String rack_rate;
    private String available_online;
    @JacksonXmlProperty( localName = "minimum_nights" )
    private String minNights;
    @JacksonXmlProperty( localName = "bed_type" )
    private String bedType;
    private String room_description;//description;
    private Rate rate;
    @JacksonXmlProperty( localName = "rooms_available" )
    private String roomsAvailable;
    private List<RoomFacility> room_facilities;
    @JacksonXmlProperty( localName = "cancellation_policy" )
    private String cancellationPolicy;
    private String formatted_cancellation_policy;
    @JacksonXmlProperty( localName = "cancellation_days" )
    @JacksonXmlElementWrapper(useWrapping=false)
    private TagValue cancellationDays;
    @JacksonXmlProperty( localName = "cancellation_hours" )
    @JacksonXmlElementWrapper(useWrapping=false)
    private TagValue cancellationHours;
    private String late_cancellation_charged_after_local_date_time;
    @JacksonXmlProperty( localName = "late_cancellation_charge" )
    private String lateCancellationCharge;
    @JacksonXmlProperty( localName = "room_terms" )
    private String roomTerms;
    private String special_offer_name;
    private String special_offer_description;
    private String breakfasts;

    public void updateRate() {
        if((type_description == null || type_description.isEmpty()) &&
            (typedescription != null && !typedescription.isEmpty()))
            type_description = typedescription;
        else if((typedescription == null || typedescription.isEmpty()) &&
            (type_description != null && !type_description.isEmpty()))
            typedescription = type_description;

        if(rate == null) return;
        if(rack_rate != null && !rack_rate.isEmpty()) {
            if(rate.getPrice().equalsIgnoreCase("Full"))
                rate.setPrice(rack_rate);
            if(rate.getNumeric_price().equalsIgnoreCase("Full"))
                rate.setNumeric_price(rack_rate);
        }
        rate.setRoomtype(type_description);
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTypedescription() {
        return typedescription;
    }

    public void setTypedescription(String typedescription) {
        this.typedescription = typedescription;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getSleeps() {
        return sleeps;
    }

    public void setSleeps(String sleeps) {
        this.sleeps = sleeps;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlternate_description() {
        return alternate_description;
    }

    public void setAlternate_description(String alternate_description) {
        this.alternate_description = alternate_description;
    }

    public String getRack_rate() {
        return rack_rate;
    }

    public void setRack_rate(String rack_rate) {
        this.rack_rate = rack_rate;
    }

    public String getAvailable_online() {
        return available_online;
    }

    public void setAvailable_online(String available_online) {
        this.available_online = available_online;
    }

    public String getMinNights() {
        return minNights;
    }

    public void setMinNights(String minNights) {
        this.minNights = minNights;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public TagValue getCancellationDays() {
        return cancellationDays;
    }

    public void setCancellationDays(TagValue cancellationDays) {
        this.cancellationDays = cancellationDays;
    }

    public TagValue getCancellationHours() {
        return cancellationHours;
    }

    public void setCancellationHours(TagValue cancellationHours) {
        this.cancellationHours = cancellationHours;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(String roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    public List<RoomFacility> getRoom_facilities() {
        return room_facilities;
    }

    public void setRoom_facilities(List<RoomFacility> room_facilities) {
        this.room_facilities = room_facilities;
    }

    public String getFormatted_cancellation_policy() {
        return formatted_cancellation_policy;
    }

    public void setFormatted_cancellation_policy(String formatted_cancellation_policy) {
        this.formatted_cancellation_policy = formatted_cancellation_policy;
    }

    public String getLate_cancellation_charged_after_local_date_time() {
        return late_cancellation_charged_after_local_date_time;
    }

    public void setLate_cancellation_charged_after_local_date_time(String late_cancellation_charged_after_local_date_time) {
        this.late_cancellation_charged_after_local_date_time = late_cancellation_charged_after_local_date_time;
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

    public String getSpecial_offer_name() {
        return special_offer_name;
    }

    public void setSpecial_offer_name(String special_offer_name) {
        this.special_offer_name = special_offer_name;
    }

    public String getSpecial_offer_description() {
        return special_offer_description;
    }

    public void setSpecial_offer_description(String special_offer_description) {
        this.special_offer_description = special_offer_description;
    }

    public String getBreakfasts() {
        return breakfasts;
    }

    public void setBreakfasts(String breakfasts) {
        this.breakfasts = breakfasts;
    }
}
