package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 17.02.14
 * Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
@JacksonXmlRootElement( localName = "search")//, namespace ="http://example.org/person" )
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesData {
    @JacksonXmlProperty( isAttribute = true )
    private String noNamespaceSchemaLocation;
    private Map response;
    @JacksonXmlElementWrapper(localName = "lr_rates")
    @JacksonXmlProperty(localName = "hotel")
    private List<HotelRatesData> hotel;

    public RatesData() {}

    public String getNoNamespaceSchemaLocation() {
        return noNamespaceSchemaLocation;
    }

    public void setNoNamespaceSchemaLocation(String noNamespaceSchemaLocation) {
        this.noNamespaceSchemaLocation = noNamespaceSchemaLocation;
    }

    public Map getResponse() {
        return response;
    }

    public void setResponse(Map response) {
        this.response = response;
    }

    public List<HotelRatesData> getHotel() {
        return hotel;
    }

    public void setHotel(List<HotelRatesData> hotel) {
        this.hotel = hotel;
    }
}
