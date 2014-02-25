package org.octocode.booking.service.conv;

import org.octocode.booking.service.conv.matcher.HotelComparator;

import java.util.List;

public class HotelComparatorRunnable implements Runnable{
    private final int number;
    private final HotelData data;
    private final List<HotelData> o2;
    private final List<HotelComparator> comparators;

    public HotelComparatorRunnable(List<HotelComparator> comparators, HotelData data, List<HotelData> o2, int number) {
        this.number = number;
        this.o2 = o2;
        this.data = data;
        this.comparators = comparators;
    }

    @Override
    public void run() {
        for (HotelComparator comparator : comparators) {
            if (comparator.match(data, o2) != null) {
//                System.out.println("success: " + (number + 1));
                ConversionService.incSuccess();
                return;
            }
        }
        System.out.println("failure: " + data);
    }

}