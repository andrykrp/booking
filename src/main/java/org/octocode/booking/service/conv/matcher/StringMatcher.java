package org.octocode.booking.service.conv.matcher;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.octocode.booking.service.conv.HotelData;
import org.octocode.booking.service.conv.HotelDataUtils;

public class StringMatcher extends Matcher {
    private double delta = 0.9;

    public StringMatcher() {
    }

    public StringMatcher(double delta) {
        this.delta = delta;
    }

    public double getDelta() {
        return delta;
    }

    @Override
    boolean check(HotelData data, HotelData data2) {
        return getStingMatch(data, data2, getDelta());
    }

    boolean getStingMatch(HotelData data, HotelData data2, Double e) {
        String s1 = HotelDataUtils.simplify(data.getName());
        String s2 = HotelDataUtils.simplify(data2.getName());
        double s1l = s1.length();
        double s2l = s2.length();
        double lev = StringUtils.getLevenshteinDistance(s1, s2);
        double pLevenshtein = 1 - Math.abs(lev / (s1l + s2l));
        double pJaroWinkler = new JaroWinklerDistance().getDistance(s1, s2);

        boolean success = pJaroWinkler > e || pLevenshtein > e;
        if (success)
            log(data, data2, String.format("Levenshtein: %.4f, JaroWinkler: %.4f", pLevenshtein, pJaroWinkler));
//      Math.abs(Math.max(pLevenshtein, pJaroWinkler) + getDelta()) > e && Math.abs(pLevenshtein - pJaroWinkler) < 2* getDelta();
        return success;
    }

    @Override
    String getMatcherName() {
        return "string matcher";
    }
}
