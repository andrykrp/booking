package org.octocode.booking.service.conv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HotelDataUtils {
    public static int max(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int el : arr)
            if (el > max)
                max = el;
        return max;
    }

    public static String simplify(String v1) {
        return v1.toLowerCase()
                .replaceAll("\\s", "")
                .replaceAll("hotel", "")
                .replaceAll("house", "")
                .replaceAll("hall", "")
                .replaceAll("the", "")
                .replaceAll("[\\&\\,\\.\\-\\+]+", "");
    }

    static List<HotelData> getData(String path, String splitter, int indID, int indName, int indLatitude, int indLongitude, int indPostcode) throws Exception {
        Date pStart = new Date();
        List<HotelData> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int i = 0;
        String line;
        String[] arr;
        while ((line = reader.readLine()) != null) {
            if (i > 0) {
                arr = line.split(splitter);
                if (arr.length > HotelDataUtils.max(indID, indName, indLatitude, indLongitude, indPostcode)) {
                    try {
                        Long id = Long.parseLong(arr[indID]);
                        String name = arr[indName];
                        Double latitude = Double.parseDouble(arr[indLatitude]);
                        Double longitude = Double.parseDouble(arr[indLongitude]);
                        String postcode = arr[indPostcode];
                        list.add(new HotelData(id, name, latitude, longitude, postcode));
                    } catch (Exception ex) {
//                        ex.printStackTrace();
                    }
                }
            }
            i++;
        }
        Date pEnd = new Date();
        System.out.println(String.format("Load i=%d size=%d duration=%.2fsec", i, list.size(), (pEnd.getTime() - pStart.getTime()) / 1000.0));
        return list;
    }
}
