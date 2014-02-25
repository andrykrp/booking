package org.octocode.booking.service.conv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

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

//        Collections.sort(list, new Comparator<HotelData>() {
//            Random random = new Random();
//            @Override
//            public int compare(HotelData o1, HotelData o2) {
//                if (o1 == null || o2 == null)
//                    return 0;
//                return simplify(o1.getName()).compareTo(simplify(o2.getName()));
//            }
//        });
        return Collections.unmodifiableList(list);
    }

    public static List<HotelData> getExpediaData() throws Exception {
        return HotelDataUtils.getData("C:\\Projects\\octocode\\booking\\data\\expedia.csv", "\\|", 0, 2, 9, 10, 7);
    }

    public static List<HotelData> getLateroomsData() throws Exception {
        return HotelDataUtils.getData("C:\\Projects\\octocode\\booking\\data\\laterooms.csv", "\\,", 0, 1, 14, 13, 6);
    }

    public static Map<CoordinateMapKey, List<HotelData>> getCoordinateMap(List<HotelData> list) {
        Map<CoordinateMapKey, List<HotelData>> map = new HashMap<>();
        for (HotelData data : list) {
            if (!map.containsKey(data.getKey())) {
                map.put(data.getKey(), new ArrayList<HotelData>());
            }
            map.get(data.getKey()).add(data);
        }
        return Collections.unmodifiableMap(map);
    }

    public static List<HotelData> getCoordinateDomain(CoordinateMapKey key, Map<CoordinateMapKey, List<HotelData>> map) {
        List<HotelData> list = new ArrayList<>();
        for (int i = key.latitude - 1; i <= key.latitude + 1; i++) {
            for (int j = key.longitude - 1; j <= key.longitude +1; j++) {
                List<HotelData> l2 = map.get(new CoordinateMapKey(i ,j));
                if (l2 != null)
                    list.addAll(l2);
            }
        }
        return list;
    }
}
