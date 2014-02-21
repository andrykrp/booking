package org.octocode.booking.service.conv.matcher;

import org.apache.commons.codec.StringEncoderComparator;
import org.apache.commons.codec.language.*;
import org.octocode.booking.service.conv.HotelData;
import org.octocode.booking.service.conv.HotelDataUtils;

public class PhoneticMatcher extends Matcher {
    @Override
    boolean check(HotelData data, HotelData data2) {
        return analyze(data, data2);
    }

    @Override
    String getMatcherName() {
        return "phonetic matcher";
    }

    private boolean analyze(HotelData data, HotelData data2) {
        String s1 = HotelDataUtils.simplify(data.getName());
        String s2 = HotelDataUtils.simplify(data2.getName());

        Soundex sndx = new Soundex();
        RefinedSoundex rsndx = new RefinedSoundex();
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        Nysiis nysiis = new Nysiis();
        Caverphone1 caverphone1 = new Caverphone1();

        StringEncoderComparator csndx = new StringEncoderComparator(sndx);
        StringEncoderComparator crsndx = new StringEncoderComparator(rsndx);
        StringEncoderComparator cdmh = new StringEncoderComparator(doubleMetaphone);
        StringEncoderComparator cnys = new StringEncoderComparator(nysiis);
        StringEncoderComparator ccvp = new StringEncoderComparator(caverphone1);

        try {
            int c1 = Math.abs(csndx.compare(s1, s2));
            int c2 = Math.abs(crsndx.compare(s1, s2));
            int c3 = Math.abs(cdmh.compare(s1, s2));
            int c4 = Math.abs(cnys.compare(s1, s2));
            int c5 = Math.abs(ccvp.compare(s1, s2));
            final boolean success = c5 < 2;
            if (success) {
                log(data, data2, String.format("%d %d %d %d %d", c1, c2, c3, c4, c5));
            }

            return success;
        } catch (Exception e) {
            return false;
        }
    }
}
