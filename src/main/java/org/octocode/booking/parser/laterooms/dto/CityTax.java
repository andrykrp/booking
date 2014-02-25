package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 18.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class CityTax {
    @JacksonXmlProperty( localName = "TypeName" )
    private String typeName;
    @JacksonXmlProperty( localName = "Value" )
    @JacksonXmlElementWrapper(useWrapping=false)
    private TagValue value;
    @JacksonXmlProperty( localName = "OptedIn" )
    @JacksonXmlElementWrapper(useWrapping=false)
    private TagValue optedIn;
    @JacksonXmlProperty( localName = "IsCityTaxArea" )
    private String isCityTaxArea;

    public CityTax() {}

    public String getIsCityTaxArea() {
        return isCityTaxArea;
    }

    public void setIsCityTaxArea(String isCityTaxArea) {
        this.isCityTaxArea = isCityTaxArea;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public TagValue getValue() {
        return value;
    }

    public void setValue(TagValue value) {
        this.value = value;
    }

    public TagValue getOptedIn() {
        return optedIn;
    }

    public void setOptedIn(TagValue optedIn) {
        this.optedIn = optedIn;
    }


}
