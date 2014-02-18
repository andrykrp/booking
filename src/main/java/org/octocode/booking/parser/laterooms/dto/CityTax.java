package org.octocode.booking.parser.laterooms.dto;

/**
 * Created with IntelliJ IDEA.
 * User: mbobrov
 * Date: 18.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class CityTax {
    private String typeName;
    private String Value;
    private String OptedIn;
    private String IsCityTaxArea;

    public String getIsCityTaxArea() {
        return IsCityTaxArea;
    }

    public void setIsCityTaxArea(String isCityTaxArea) {
        IsCityTaxArea = isCityTaxArea;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getOptedIn() {
        return OptedIn;
    }

    public void setOptedIn(String optedIn) {
        OptedIn = optedIn;
    }

}
