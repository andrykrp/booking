package org.octocode.booking.service.conv;

public class HotelData {
    Long id;
    String name;
    Double latitude;
    Double longitude;
    String postcode;

    CoordinateMapKey key;

    HotelData(Long id, String name, Double latitude, Double longitude, String postcode) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postcode = postcode;
        key = new CoordinateMapKey(latitude, longitude);
    }

    Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getPostcode() {
        return postcode;
    }

    public CoordinateMapKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.format("Hotel\tid[%d]\tname[%s]\tlatitude[%.6f]\tlongitude[%.6f]\tpostcode[%s]", id, name, latitude, longitude, postcode);
    }
}
