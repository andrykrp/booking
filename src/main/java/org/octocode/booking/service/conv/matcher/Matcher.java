package org.octocode.booking.service.conv.matcher;

import org.octocode.booking.service.conv.HotelData;

public abstract class Matcher {
    abstract boolean check(HotelData data, HotelData data2);

    void log(HotelData data, HotelData data2, String message) {
//        System.out.println(data);
//        System.out.println(data2);
//        if (message != null)
//            System.out.println(message);
//        System.out.println(getMatcherName());
//        System.out.println();
    }

    abstract String getMatcherName();
}
