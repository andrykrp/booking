package org.octocode.booking.parser.laterooms.dto;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 17.02.14
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
public class Rate {
    private String date;
    private String formatted_date;
    private String price;
    private String roomtype;
    private String breakfast_included;
    private String dinner_included;
    private String cancellation_policy;
    private String cancellation_days;
    private String cancellation_hours;
    private String room_terms;
    private String special_offer_name;
    private String special_offer_description;
    private String ref;
    private String breakfasts;
    private String sleeps;
    private String adults;
    private String children;
    private String rooms_available;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormatted_date() {
        return formatted_date;
    }

    public void setFormatted_date(String formatted_date) {
        this.formatted_date = formatted_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getBreakfast_included() {
        return breakfast_included;
    }

    public void setBreakfast_included(String breakfast_included) {
        this.breakfast_included = breakfast_included;
    }

    public String getDinner_included() {
        return dinner_included;
    }

    public void setDinner_included(String dinner_included) {
        this.dinner_included = dinner_included;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public void setCancellation_policy(String cancellation_policy) {
        this.cancellation_policy = cancellation_policy;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getBreakfasts() {
        return breakfasts;
    }

    public void setBreakfasts(String breakfasts) {
        this.breakfasts = breakfasts;
    }

    public String getSleeps() {
        return sleeps;
    }

    public void setSleeps(String sleeps) {
        this.sleeps = sleeps;
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

    public String getRooms_available() {
        return rooms_available;
    }

    public void setRooms_available(String rooms_available) {
        this.rooms_available = rooms_available;
    }
}
