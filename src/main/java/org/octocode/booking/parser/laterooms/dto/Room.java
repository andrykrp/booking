package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 22.02.14
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
    private String ref;
    private String typedescription;
    private String type;
    private String typename;//bed_type
    private String sleeps;
    private String breakfast;
    private String dinner;
    private String adults;
    private String children;
    private String description;
    private String alternate_description;
    private String rack_rate;
    private String available_online;
    private String minimum_nights;
    private String room_description;//description;
    private Rate rate;
    private String rooms_available;
    private List<RoomFacility> room_facilities;
    private String cancellation_policy;
    private String formatted_cancellation_policy;
    private String cancellation_days;
    private String cancellation_hours;
    private String late_cancellation_charged_after_local_date_time;
    private String late_cancellation_charge;
    private String room_terms;
    private String special_offer_name;
    private String special_offer_description;
    private String breakfasts;

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

    public String getMinimum_nights() {
        return minimum_nights;
    }

    public void setMinimum_nights(String minimum_nights) {
        this.minimum_nights = minimum_nights;
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

    public String getRooms_available() {
        return rooms_available;
    }

    public void setRooms_available(String rooms_available) {
        this.rooms_available = rooms_available;
    }

    public List<RoomFacility> getRoom_facilities() {
        return room_facilities;
    }

    public void setRoom_facilities(List<RoomFacility> room_facilities) {
        this.room_facilities = room_facilities;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public void setCancellation_policy(String cancellation_policy) {
        this.cancellation_policy = cancellation_policy;
    }

    public String getFormatted_cancellation_policy() {
        return formatted_cancellation_policy;
    }

    public void setFormatted_cancellation_policy(String formatted_cancellation_policy) {
        this.formatted_cancellation_policy = formatted_cancellation_policy;
    }

    public String getCancellation_days() {
        return cancellation_days;
    }

    public void setCancellation_days(String cancellation_days) {
        this.cancellation_days = cancellation_days;
    }

    public String getCancellation_hours() {
        return cancellation_hours;
    }

    public void setCancellation_hours(String cancellation_hours) {
        this.cancellation_hours = cancellation_hours;
    }

    public String getLate_cancellation_charged_after_local_date_time() {
        return late_cancellation_charged_after_local_date_time;
    }

    public void setLate_cancellation_charged_after_local_date_time(String late_cancellation_charged_after_local_date_time) {
        this.late_cancellation_charged_after_local_date_time = late_cancellation_charged_after_local_date_time;
    }

    public String getLate_cancellation_charge() {
        return late_cancellation_charge;
    }

    public void setLate_cancellation_charge(String late_cancellation_charge) {
        this.late_cancellation_charge = late_cancellation_charge;
    }

    public String getRoom_terms() {
        return room_terms;
    }

    public void setRoom_terms(String room_terms) {
        this.room_terms = room_terms;
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
