package org.octocode.booking.service.conv.matcher;

import org.octocode.booking.service.conv.HotelData;

import java.util.List;

public class HotelComparator {
    Matcher[] arr;
    String title;

    public HotelComparator(String title, Matcher... arr) {
        this.arr = arr;
        this.title = title;
    }

    public HotelData match(HotelData data, List<HotelData> o2) {
        for (HotelData data2 : o2) {
            int success = 0;
            for (Matcher matcher : arr)
                if (matcher.check(data, data2))
                    success++;
            if (success == arr.length){
                System.out.println(String.format("success [%s]", title));
                return data2;
            }
        }
        return null;
    }

}
