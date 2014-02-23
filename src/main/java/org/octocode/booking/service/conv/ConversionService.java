package org.octocode.booking.service.conv;

import org.apache.commons.codec.StringEncoderComparator;
import org.apache.commons.codec.language.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.octocode.booking.service.conv.matcher.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConversionService {
    List<HotelComparator> comparators = new ArrayList<>();

    public void addComparator(HotelComparator comparator) {
        comparators.add(comparator);
    }

    public List<HotelComparator> getComparators() {
        return comparators;
    }

    public void compare(List<HotelData> o1, List<HotelData> o2) {
        Matcher lStringMatcher = new StringMatcher(0.8);
        Matcher mStringMatcher = new StringMatcher(0.9);
        Matcher hStringMatcher = new StringMatcher(0.95);
        Matcher distanceMatcher = new DistanceMatcher();
        Matcher postcodeMatcher = new PostcodeMatcher();
        Matcher phoneticMatcher = new PhoneticMatcher();

        HotelComparator comparatorSD = new HotelComparator("string-m/distance", mStringMatcher, distanceMatcher);
        HotelComparator comparatorSP = new HotelComparator("string-h/postcode", hStringMatcher, postcodeMatcher);
        HotelComparator comparatorDP = new HotelComparator("string-l/distance/postcode", lStringMatcher, distanceMatcher, postcodeMatcher);

        addComparator(comparatorSD);
        addComparator(comparatorSP);
        addComparator(comparatorDP);

        List<HotelData> list = new ArrayList<>();

        Date pStart = new Date();
        int size = 0;
        for (int i = 0; i < 8000; i++) {
            System.out.println("------------------------------------------------------------");
            System.out.println("number: " + (i + 1));

            boolean success = false;
            HotelData data = o1.get(i);
            for (HotelComparator comparator : getComparators()) {
                if (comparator.match(data, o2) != null){
                    success = true;
                    size++;
                    break;
                }
            }
            if (!success)
                list.add(data);
        }
        Date pEnd = new Date();
        System.out.println(String.format("Mapping size=%d duration=%.2fsec", size, (pEnd.getTime() - pStart.getTime()) / 1000.0));
        System.out.println("Not matched hotels:");
        for (HotelData hotel : list)
            System.out.println(hotel);
    }
}
