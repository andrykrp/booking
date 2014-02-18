package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 17.02.14
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelData {
    private static final Logger LOGGER = Logger.getLogger(HotelData.class);

    private String hotel_ref;
    private String hotel_name;
    private String hotel_star;
    private String hotel_address;
    private String hotel_city;
    private String hotel_county;
    private String hotel_pcode;
    private String hotel_max_child_age;
    private String hotel_description;
    private String hotel_directions;
    private String hotel_link;
    private String check_in;
    private String check_out;
    private String hotel_no_of_rooms;
    private List images;
    //@JacksonXmlElementWrapper(localName = "geo_code")
    //@JacksonXmlProperty( localName = "long" )
    //private String longitude;
    //@JacksonXmlElementWrapper(localName = "geo_code")
    //@JacksonXmlProperty( localName = "lat" )
    //private String latitude;
    private Map geo_code;
    @JacksonXmlProperty( localName = "long" )
    private String longitude;
    private String lat;
    private String hotel_distance;
    private String customer_rating;
    private String prices_from;
    private String star_awarded_by;
    private String star_accomodation_type;
    //@JacksonXmlProperty(localname="rack_rate")
    private String rack_rate;
    //private List<Rate> hotel_rooms;
    @JacksonXmlElementWrapper(localName = "hotel_rooms")
    @JacksonXmlProperty( localName = "rate" )
    private Rate rate;
    private String cancellation_type;
    private String cancellation_policy;
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
    private CityTax cityTax;

    public HotelData() {}

    public HotelData(String name) {
        LOGGER.info("Constructor parameter: "+name);
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getHotel_ref() {
        return hotel_ref;
    }

    public void setHotel_ref(String hotel_ref) {
        this.hotel_ref = hotel_ref;
    }

    public Map getGeo_code() {
        return geo_code;
    }

    public void setGeo_code(Map geo_code) {
        this.geo_code = geo_code;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    /*public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }*/

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_star() {
        return hotel_star;
    }

    public void setHotel_star(String hotel_star) {
        this.hotel_star = hotel_star;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_county() {
        return hotel_county;
    }

    public void setHotel_county(String hotel_county) {
        this.hotel_county = hotel_county;
    }

    public String getHotel_pcode() {
        return hotel_pcode;
    }

    public void setHotel_pcode(String hotel_pcode) {
        this.hotel_pcode = hotel_pcode;
    }

    public String getHotel_max_child_age() {
        return hotel_max_child_age;
    }

    public void setHotel_max_child_age(String hotel_max_child_age) {
        this.hotel_max_child_age = hotel_max_child_age;
    }

    public String getHotel_description() {
        return hotel_description;
    }

    public void setHotel_description(String hotel_description) {
        this.hotel_description = hotel_description;
    }

    public String getHotel_directions() {
        return hotel_directions;
    }

    public void setHotel_directions(String hotel_directions) {
        this.hotel_directions = hotel_directions;
    }

    public String getHotel_link() {
        return hotel_link;
    }

    public void setHotel_link(String hotel_link) {
        this.hotel_link = hotel_link;
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

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
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

    public String getPrices_from() {
        return prices_from;
    }

    public void setPrices_from(String prices_from) {
        this.prices_from = prices_from;
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
