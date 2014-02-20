package org.octocode.booking.parser.laterooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagValue {

    @JacksonXmlText
    private String stringValue;
    @JacksonXmlProperty( localName = "nil", isAttribute = true )
    private String nilAttribute;

    public TagValue() {
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getNilAttribute() {
        return nilAttribute;
    }

    public void setNilAttribute(String nilAttribute) {
        this.nilAttribute = nilAttribute;
    }
}
