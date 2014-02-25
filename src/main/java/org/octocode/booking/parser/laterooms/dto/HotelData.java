package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelData {
    private static final Logger LOGGER = Logger.getLogger(HotelData.class);

    //@JacksonXmlProperty( localName = "hotel_ref" )
    private Long hotel_ref;
    //@JacksonXmlProperty( localName = "hotel_name" )
    private String hotel_name;
    @JacksonXmlProperty( localName = "hotel_star" )
    private String hotelRating;
    @JacksonXmlProperty( localName = "hotel_address" )
    private String address;
    @JacksonXmlProperty( localName = "hotel_city" )
    private String city;
    @JacksonXmlProperty( localName = "hotel_county" )
    private String countryCode;
    @JacksonXmlProperty( localName = "hotel_pcode" )
    private String postalCode;
    private String hotel_max_child_age;
    @JacksonXmlProperty( localName = "hotel_description" )
    private String locationDescription;
    @JacksonXmlProperty( localName = "alternate_description" )
    private String shortDescription;
    private String hotel_directions;
    @JacksonXmlProperty( localName = "hotel_link" )
    private String deepLink;
    private String check_in;
    private String check_out;
    private String hotel_no_of_rooms;
    @JacksonXmlProperty( localName = "images" )
    private String thumbNailUrl;
    private Map<String, String> geo_code;
    private String hotel_distance;
    private String customer_rating;
    @JacksonXmlProperty( localName = "prices_from" )
    private String lowRate;
    @JacksonXmlProperty( localName = "hotel_currency" )
    private String rateCurrencyCode;
    private String star_awarded_by;
    private String star_accomodation_type;
    //@JacksonXmlProperty(localname="rack_rate")
    private String rack_rate;
    //private List<Rate> hotel_rooms;
    @JacksonXmlElementWrapper(localName = "hotel_rooms")
    //@JacksonXmlProperty( localName = "rate" )
    private List<Rate> rate;
    private String cancellation_type;
    private String cancellation_policy;
    private String hotel_cancellation_days;
    private String hotel_cancellation_hours;
    private String hotel_terms;
    private String conditions_of_booking;
    /* Privacy policy, terms & conditions and disclaimer are omitted,
    as they are the same for all hotels and bookings*/
    @JacksonXmlElementWrapper(localName = "accepted_credit_cards")
    //@JacksonXmlProperty( localName = "credit_card" )
    private List<String> accepted_credit_cards;
    @JacksonXmlElementWrapper(localName = "accepted_payment_credit_cards")
    //@JacksonXmlProperty(localName = "credit_card")
    private List<String> accepted_payment_credit_cards;
    @JacksonXmlElementWrapper(localName = "hotel_appeals")
    @JacksonXmlProperty( localName = "appeal" )
    private List<String> hotel_appeals;
    @JacksonXmlElementWrapper(localName = "hotel_facilities")
    @JacksonXmlProperty( localName = "facility" )
    private List<String> hotel_facilities;
    private String hotel_important_information;
    @JacksonXmlElementWrapper(useWrapping=false)
    @JacksonXmlProperty( localName = "CityTax" )
    private CityTax cityTax;

    public HotelData() {}

    public HotelData(String name) {
        LOGGER.info("Constructor parameter: "+name);
    }

    public List<Rate> getRate() {
        return rate;
    }

    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

    public Long getHotel_ref() {
        return hotel_ref;
    }

    public void setHotel_ref(Long hotel_ref) {
        this.hotel_ref = hotel_ref;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getRateCurrencyCode() {
        return rateCurrencyCode;
    }

    public void setRateCurrencyCode(String rateCurrencyCode) {
        this.rateCurrencyCode = rateCurrencyCode;
    }

    public String getHotel_cancellation_days() {
        return hotel_cancellation_days;
    }

    public void setHotel_cancellation_days(String hotel_cancellation_days) {
        this.hotel_cancellation_days = hotel_cancellation_days;
    }

    public String getHotel_cancellation_hours() {
        return hotel_cancellation_hours;
    }

    public void setHotel_cancellation_hours(String hotel_cancellation_hours) {
        this.hotel_cancellation_hours = hotel_cancellation_hours;
    }

    public String getHotel_terms() {
        return hotel_terms;
    }

    public void setHotel_terms(String hotel_terms) {
        this.hotel_terms = hotel_terms;
    }

    public String getConditions_of_booking() {
        return conditions_of_booking;
    }

    public void setConditions_of_booking(String conditions_of_booking) {
        this.conditions_of_booking = conditions_of_booking;
    }

    public Map getGeo_code() {
        return geo_code;
    }

    public void setGeo_code(Map geo_code) {
        this.geo_code = geo_code;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHotel_max_child_age() {
        return hotel_max_child_age;
    }

    public void setHotel_max_child_age(String hotel_max_child_age) {
        this.hotel_max_child_age = hotel_max_child_age;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getHotel_directions() {
        return hotel_directions;
    }

    public void setHotel_directions(String hotel_directions) {
        this.hotel_directions = hotel_directions;
    }

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getHotel_no_of_rooms() {
        return hotel_no_of_rooms;
    }

    public void setHotel_no_of_rooms(String hotel_no_of_rooms) {
        this.hotel_no_of_rooms = hotel_no_of_rooms;
    }

    public String getThumbNailUrl() {
        return thumbNailUrl;
    }

    public void setThumbNailUrl(String thumbNailUrl) {
        this.thumbNailUrl = thumbNailUrl;
    }

    public String getHotel_distance() {
        return hotel_distance;
    }

    public void setHotel_distance(String hotel_distance) {
        this.hotel_distance = hotel_distance;
    }

    public String getCustomer_rating() {
        return customer_rating;
    }

    public void setCustomer_rating(String customer_rating) {
        this.customer_rating = customer_rating;
    }

    public String getLowRate() {
        return lowRate;
    }

    public void setLowRate(String lowRate) {
        this.lowRate = lowRate;
    }

    public String getStar_awarded_by() {
        return star_awarded_by;
    }

    public void setStar_awarded_by(String star_awarded_by) {
        this.star_awarded_by = star_awarded_by;
    }

    public String getStar_accomodation_type() {
        return star_accomodation_type;
    }

    public void setStar_accomodation_type(String star_accomodation_type) {
        this.star_accomodation_type = star_accomodation_type;
    }

    public String getRack_rate() {
        return rack_rate;
    }

    public void setRack_rate(String rack_rate) {
        this.rack_rate = rack_rate;
    }

    public String getCancellation_type() {
        return cancellation_type;
    }

    public void setCancellation_type(String cancellation_type) {
        this.cancellation_type = cancellation_type;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public void setCancellation_policy(String cancellation_policy) {
        this.cancellation_policy = cancellation_policy;
    }

    public List getAccepted_credit_cards() {
        return accepted_credit_cards;
    }

    public void setAccepted_credit_cards(List accepted_credit_cards) {
        this.accepted_credit_cards = accepted_credit_cards;
    }

    public List getAccepted_payment_credit_cards() {
        return accepted_payment_credit_cards;
    }

    public void setAccepted_payment_credit_cards(List accepted_payment_credit_cards) {
        this.accepted_payment_credit_cards = accepted_payment_credit_cards;
    }

    public List getHotel_appeals() {
        return hotel_appeals;
    }

    public void setHotel_appeals(List hotel_appeals) {
        this.hotel_appeals = hotel_appeals;
    }

    public List getHotel_facilities() {
        return hotel_facilities;
    }

    public void setHotel_facilities(List hotel_facilities) {
        this.hotel_facilities = hotel_facilities;
    }

    public String getHotel_important_information() {
        return hotel_important_information;
    }

    public void setHotel_important_information(String hotel_important_information) {
        this.hotel_important_information = hotel_important_information;
    }

    public CityTax getCityTax() {
        return cityTax;
    }

    public void setCityTax(CityTax cityTax) {
        this.cityTax = cityTax;
    }
}
