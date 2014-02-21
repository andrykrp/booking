package org.octocode.booking.service.conv.matcher;

import org.octocode.booking.service.conv.HotelData;

import static org.octocode.booking.service.conv.HotelDataUtils.simplify;

public class PostcodeMatcher extends Matcher {
    @Override
    boolean check(HotelData data, HotelData data2) {
        final String postcode1 = data.getPostcode();
        final String postcode2 = data2.getPostcode();
        final boolean success = postcode1 != null &&
                postcode2 != null &&
                simplify(postcode1).equals(simplify(postcode2));
        if (success)
            log(data, data2, null);
        return success;
    }

    @Override
    String getMatcherName() {
        return "postcode matcher";
    }
}
