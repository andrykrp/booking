package org.octocode.booking.service.conv;

import org.octocode.booking.service.conv.matcher.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ConversionService {
    private static final int NTHREDS = 20;
    private final List<HotelComparator> comparators;

    public ConversionService() {
        List<HotelComparator> list = new ArrayList<>();
        Matcher lStringMatcher = new StringMatcher(0.8);
        Matcher mStringMatcher = new StringMatcher(0.9);
        Matcher hStringMatcher = new StringMatcher(0.95);
        Matcher distanceMatcher = new DistanceMatcher();
        Matcher postcodeMatcher = new PostcodeMatcher();
        Matcher phoneticMatcher = new PhoneticMatcher();

        HotelComparator comparatorSD = new HotelComparator("string-m/distance", mStringMatcher, distanceMatcher);
        HotelComparator comparatorSP = new HotelComparator("string-h/postcode", hStringMatcher, postcodeMatcher);
        HotelComparator comparatorDP = new HotelComparator("string-l/distance/postcode", lStringMatcher, distanceMatcher, postcodeMatcher);

        list.add(comparatorSD);
        list.add(comparatorSP);
        list.add(comparatorDP);
        comparators = Collections.unmodifiableList(list);
    }

    public static void main(String[] args) throws Exception {
        ConversionService service = new ConversionService();
        List<HotelData> e = Collections.unmodifiableList(HotelData.getExpediaData());
        List<HotelData> l = Collections.unmodifiableList(HotelData.getLateroomsData());
        service.compare(l, e);
    }

    public void compare(final List<HotelData> o1, final List<HotelData> o2) {
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);

        Date pStart = new Date();
        for (int i = 0; i < 100; i++) {
            HotelComparatorRunnable worker = new HotelComparatorRunnable(comparators, o1.get(i), o2, i);
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
        System.out.println(String.format("Mapping size=%d duration=%.2fsec", 0, (pEnd.getTime() - pStart.getTime()) / 1000.0));
        System.out.println("Not matched hotels:");
    }
}
