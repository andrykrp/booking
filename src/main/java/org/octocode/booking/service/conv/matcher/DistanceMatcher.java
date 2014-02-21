package org.octocode.booking.service.conv.matcher;

import org.octocode.booking.service.conv.HotelData;

public class DistanceMatcher extends Matcher {
    private Double delta = 0.4;

    public DistanceMatcher() {
    }

    public DistanceMatcher(Double delta) {
        this.delta = delta;
    }

    public Double getDelta() {
        return delta;
    }

    private double getDistance(HotelData o1, HotelData o2) {
        double lon = o1.getLongitude();
        double lat = o1.getLatitude();
        double lon2 = o2.getLongitude();
        double lat2 = o2.getLatitude();
        return 111.2 * Math.sqrt(Math.pow((lon - lon2), 2) + Math.pow((lat - lat2) * Math.cos(Math.PI * lon / 180), 2));
    }

    @Override
    boolean check(HotelData data, HotelData data2) {
        double distance = getDistance(data, data2);
        if (distance < getDelta()) {
            log(data, data2, String.format("distance [%.1f]m", distance * 1000));
            return true;
        }
        return false;
    }

    @Override
    String getMatcherName() {
        return "distance matcher";
    }
}
