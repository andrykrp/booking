package org.octocode.booking.service;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    private static final Double e = 0.75;
    private static final Double d = 0.03;

    public boolean getStingMatchApproach(String v1, String v2) {
        String s1 = v1.toLowerCase().replaceAll("\\s","");
        String s2 = v2.toLowerCase().replaceAll("\\s","");
        double s1l = s1.length();
        double s2l = s2.length();
        double lev = StringUtils.getLevenshteinDistance(s1, s2);
        double pLevenshtein = 1 - Math.abs(lev / (s1l + s2l));
        double pJaroWinkler = new JaroWinklerDistance().getDistance(s1, s2);
        boolean match = new MatchRatingApproachEncoder().isEncodeEquals(s1, s2);

        System.out.println(String.format("[%s] matching [%s]", s1, s2));
        System.out.println(String.format("len1: %.0f, len2: %.0f, dist: %.0f", s1l, s2l, lev));
        System.out.println(String.format("Levenshtein: %.4f, JaroWinkler: %.4f, MatchRating: %b", pLevenshtein, pJaroWinkler, match));

        return pJaroWinkler > e || pJaroWinkler > e && Math.abs(pLevenshtein - pJaroWinkler) < d || Math.abs(Math.max(pLevenshtein, pJaroWinkler) - d) < e && match;

    }

    public static void main(String[] args) throws EncoderException {
        String s1 = "Ornenburg ";
        String s2 = "Hotel Orenburg";
        System.out.println(String.format("string match: %b", new ConversionService().getStingMatchApproach(s1, s2)));
    }
}
