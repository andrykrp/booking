package org.octocode.booking.service.conv;

import java.util.List;

public class HotelData {
    Long id;
    String name;
    Double latitude;
    Double longitude;
    String postcode;

    HotelData(Long id, String name, Double latitude, Double longitude, String postcode) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postcode = postcode;
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

    @Override
    public String toString() {
        return String.format("Hotel\tid[%d]\tname[%s]\tlatitude[%.6f]\tlongitude[%.6f]\tpostcode[%s]", id, name, latitude, longitude, postcode);
    }

    public static List<HotelData> getExpediaData() throws Exception {
        return HotelDataUtils.getData("C:\\Projects\\octocode\\booking\\data\\expedia.csv", "\\|", 0, 2, 9, 10, 7);
    }

    public static List<HotelData> getLateroomsData() throws Exception {
        return HotelDataUtils.getData("C:\\Projects\\octocode\\booking\\data\\laterooms.csv", "\\,", 0, 1, 14, 13, 6);
    }
}
