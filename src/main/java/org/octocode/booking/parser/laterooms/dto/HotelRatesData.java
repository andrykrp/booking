package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 24.02.14
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelRatesData {
    private static final Logger LOGGER = Logger.getLogger(HotelData.class);

    //@JacksonXmlProperty( localName = "hotel_ref" )
    private Long hotel_ref;
    @JacksonXmlProperty( localName = "hotel_currency" )
    private String rateCurrencyCode;
    @JacksonXmlElementWrapper(localName = "hotel_rooms")
    @JacksonXmlProperty(localName = "room")
    private List<Room> room;
    private String cancellation_type;
    private String cancellation_policy;
    @JacksonXmlElementWrapper(useWrapping=false)
    @JacksonXmlProperty( localName = "CityTax" )
    private CityTax cityTax;

    public Long getHotel_ref() {
        return hotel_ref;
    }

    public void setHotel_ref(Long hotel_ref) {
        this.hotel_ref = hotel_ref;
    }

    public String getRateCurrencyCode() {
        return rateCurrencyCode;
    }

    public void setRateCurrencyCode(String rateCurrencyCode) {
        this.rateCurrencyCode = rateCurrencyCode;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
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

    public CityTax getCityTax() {
        return cityTax;
    }

    public void setCityTax(CityTax cityTax) {
        this.cityTax = cityTax;
    }
}
