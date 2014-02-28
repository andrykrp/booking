package org.octocode.booking.service.conv;

import org.octocode.booking.service.conv.matcher.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ConversionService {
    private static final int NTHREDS = 4;
    public static final int ITER = 6000;
    private final List<HotelComparator> comparators;

    private static int success = 0;

    public static synchronized int getSuccess() {
        return success;
    }

    public static synchronized void incSuccess() {
        success++;
    }

    public ConversionService() {
        List<HotelComparator> list = new ArrayList<>();
        Matcher lStringMatcher = new StringMatcher(0.8);
        Matcher mStringMatcher = new StringMatcher(0.9);
        Matcher hStringMatcher = new StringMatcher(0.95);
        Matcher fStringMatcher = new StringMatcher(0.99);
        Matcher mDistanceMatcher = new DistanceMatcher(0.4);
        Matcher hDistanceMatcher = new DistanceMatcher(0.6);
        Matcher fDistanceMatcher = new DistanceMatcher(1.0);
        Matcher postcodeMatcher = new PostcodeMatcher();
        Matcher phoneticMatcher = new PhoneticMatcher();

        HotelComparator comparatorSD = new HotelComparator("string-m/distance", mStringMatcher, mDistanceMatcher);
        HotelComparator comparatorSD2 = new HotelComparator("string-h/distance-h", hStringMatcher, hDistanceMatcher);
        HotelComparator comparatorSD3 = new HotelComparator("string-f/distance-f", fStringMatcher, fDistanceMatcher);
        HotelComparator comparatorSP = new HotelComparator("string-h/postcode", mStringMatcher, postcodeMatcher);
        HotelComparator comparatorDP = new HotelComparator("string-l/distance/postcode", lStringMatcher, mDistanceMatcher, postcodeMatcher);

        list.add(comparatorSD);
        list.add(comparatorSD2);
        list.add(comparatorSD3);
        list.add(comparatorSP);
        list.add(comparatorDP);
        comparators = Collections.unmodifiableList(list);
    }

    public static void main(String[] args) throws Exception {
        ConversionService service = new ConversionService();
        List<HotelData> elist = HotelDataUtils.getExpediaData();
        Map<CoordinateMapKey, List<HotelData>> emap = HotelDataUtils.getCoordinateMap(elist);

        List<HotelData> l = HotelDataUtils.getLateroomsData();
        service.compare(l, emap);
    }

    public void compare(final List<HotelData> list, final Map<CoordinateMapKey, List<HotelData>> map) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);

        Date pStart = new Date();
        for (int i = 0; i < ITER; i++) {
            final HotelData hotelData = list.get(i);
            List<HotelData> dataList = map.get(hotelData.getKey());

            if (dataList == null) {
                System.out.println("failure: " + hotelData);
                dataList = HotelDataUtils.getCoordinateDomain(hotelData.getKey(), map);
            }

            HotelComparatorRunnable worker = new HotelComparatorRunnable(comparators, hotelData, dataList, i);
            executor.execute(worker);
        }

        executor.shutdown();
        try {
            boolean timeoutExceed = !executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println(timeoutExceed ? "by timeout" : "by execution");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");

        Date pEnd = new Date();
        int size = ConversionService.getSuccess();
        System.out.println(String.format("Mapping size=%d[%.2f] duration=%.2fsec", size,  (100.0 * size / ITER), (pEnd.getTime() - pStart.getTime()) / 1000.0));
        System.out.println("Not matched hotels:");
    }
}
