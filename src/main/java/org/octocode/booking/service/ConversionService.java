package org.octocode.booking.service;

import org.apache.commons.codec.StringEncoderComparator;
import org.apache.commons.codec.language.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.spell.JaroWinklerDistance;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConversionService {
    private static final Double d = 0.03;

    private static final Double e = 0.9;
    private static final double DELTA = 0.35;

    private static final Double e2 = 0.70;
    private static final double DELTA2 = 0.07;

    public static void main(String[] args) throws Exception {
        ConversionService service = new ConversionService();
        List<ObjData> e = service.getExpediaData();
        List<ObjData> l = service.getLateroomsData();
        service.compare(l, e);
    }

    public void compare(List<ObjData> o1, List<ObjData> o2) {
        List<ObjData> ids = new ArrayList<>();

        Date pStart = new Date();
        int size = 0;
        for (int i = 0; i < 25; i++) {
            System.out.println("------------------------------------------------------------");
            System.out.println("number: " + (i + 1));

            ObjData data = o1.get(i);
            ObjData data2 = getMatch(data, o2, DELTA, e);
            if (data2 != null) {
                size++;
            } else {
                ObjData data3 = getFoneticMatch(data, o2, DELTA2, e2);
                if (data3 != null) {
//                    fonetic(data.getName(), data3.getName());
                    size++;
                } else {
                    ids.add(data);
                }
            }
        }
        Date pEnd = new Date();
        System.out.println(String.format("Mapping size=%d duration=%.2fsec", size, (pEnd.getTime() - pStart.getTime())/1000.0));
        System.out.println(ids);
    }

    private ObjData getMatch(ObjData data, List<ObjData> o2, Double delta, Double e) {
        ConversionService service = new ConversionService();
        for (int j = 0; j < o2.size(); j++) {
            ObjData data2 = o2.get(j);
            if (service.getStingMatchApproach(data.getName(), data2.getName(), e)) {
                double distance = getDistance(data, data2);
                if (distance < delta) {
                    System.out.println(data);
                    System.out.println(data2);
                    System.out.println(String.format("distance [%.1f] m", distance*1000));
                    System.out.println();
                    return data2;
                }
            }
        }
        return null;
    }

    private ObjData getFoneticMatch(ObjData data, List<ObjData> o2, Double delta, Double e) {
        ConversionService service = new ConversionService();
        for (int j = 0; j < o2.size(); j++) {
            ObjData data2 = o2.get(j);
            if (service.fonetic(data.getName(), data2.getName())) {
                double distance = getDistance(data, data2);
                if (distance < delta) {
                    System.out.println(data);
                    System.out.println(data2);
                    System.out.println(String.format("distance [%.1f] m", distance*1000));
                    System.out.println();
                    return data2;
                }
            }
        }
        return null;
    }

    private double getDistance(ObjData o1, ObjData o2) {
        double lon = o1.getLongitude();
        double lat = o1.getLatitude();
        double lon2 = o2.getLongitude();
        double lat2 = o2.getLatitude();
        return 111.2 * Math.sqrt( Math.pow((lon - lon2), 2) + Math.pow((lat - lat2)*Math.cos(Math.PI*lon/180), 2));
    }

    public boolean getStingMatchApproach(String v1, String v2, Double e) {
        String s1 = simplify(v1);
        String s2 = simplify(v2);
        double s1l = s1.length();
        double s2l = s2.length();
        double lev = StringUtils.getLevenshteinDistance(s1, s2);
        double pLevenshtein = 1 - Math.abs(lev / (s1l + s2l));
        double pJaroWinkler = new JaroWinklerDistance().getDistance(s1, s2);

        boolean success =
                pJaroWinkler > e ||
                        pLevenshtein > e ||
                        Math.abs(Math.max(pLevenshtein, pJaroWinkler) + d) > e && Math.abs(pLevenshtein - pJaroWinkler) < 2*d;
//        return success;

        if (success) {
            System.out.println("------------------------------------------------------------");
            System.out.println(String.format("[%s] matching [%s]", v1, v2));
            System.out.println(String.format("len1: %.0f, len2: %.0f, dist: %.0f", s1l, s2l, lev));
            System.out.println(String.format("Levenshtein: %.4f, JaroWinkler: %.4f", pLevenshtein, pJaroWinkler));
            System.out.println();
            return true;
        }

        return false;
    }

    private boolean fonetic(String v1, String v2) {
        String s1 = simplify(v1);
        String s2 = simplify(v2);

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
            if (c5 < 2) {
//                System.out.println(c1);
//                System.out.println(c2);
//                System.out.println(c3);
//                System.out.println(c4);
//                System.out.println(c5);
//                System.out.println("");
                return true;
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private String simplify(String v1) {
        return v1.toLowerCase()
                .replaceAll("\\s", "")
                .replaceAll("hotel", "")
                .replaceAll("house", "")
                .replaceAll("hall", "")
                .replaceAll("the", "")
                .replaceAll("[\\&\\,\\.\\-\\+]+", "");
    }

    List<ObjData> getExpediaData() throws Exception {
        Date pStart = new Date();
        List<ObjData> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\booking\\data\\feed\\expedia.csv"));
        int i = 0;
        String line;
        String[] arr;
        while ((line = reader.readLine()) != null) {
            if (i > 0) {
                arr = line.split("\\|");
                if (arr.length > 10) {
                    try {
                        Long id = Long.parseLong(arr[0]);
                        String name = arr[2];
                        Double latitude = Double.parseDouble(arr[9]);
                        Double longitude = Double.parseDouble(arr[10]);
                        list.add(new ObjData(id, name, latitude, longitude));
                    } catch (Exception ex) {
//                        ex.printStackTrace();
                    }
                }
            }
            i++;
        }
        Date pEnd = new Date();
        System.out.println(String.format("Expedia i=%d size=%d duration=%.2fsec", i, list.size(), (pEnd.getTime() - pStart.getTime())/1000.0));
        return list;
    }

    List<ObjData> getLateroomsData() throws Exception {
        Date pStart = new Date();
        List<ObjData> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Java\\booking\\data\\feed\\laterooms.csv"));
        int i = 0;
        String line;
        String[] arr;
        while ((line = reader.readLine()) != null) {
            if (i > 0) {
                arr = line.split("\\,");
                if (arr.length > 14) {
                    try {
                        Long id = Long.parseLong(arr[0]);
                        String name = arr[1];
                        Double longitude = Double.parseDouble(arr[13]);
                        Double latitude = Double.parseDouble(arr[14]);
                        list.add(new ObjData(id, name, latitude, longitude));
                    } catch (Exception ex) {
//                        ex.printStackTrace();
                    }
                }
            }
            i++;
        }
        Date pEnd = new Date();
        System.out.println(String.format("Laterooms i=%d size=%d duration=%.2fsec", i, list.size(), (pEnd.getTime() - pStart.getTime())/1000.0));
        return list;
    }

    class ObjData {
        Long id;
        String name;
        Double latitude;
        Double longitude;

        ObjData(Long id, String name, Double latitude, Double longitude) {
            this.id = id;
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        Long getId() {
            return id;
        }

        String getName() {
            return name;
        }

        Double getLatitude() {
            return latitude;
        }

        Double getLongitude() {
            return longitude;
        }

        @Override
        public String toString() {
            return String.format("Hotel\tid[%d]\tname[%s]\tlatitude[%.6f]\tlongitude[%.6f]", id, name, latitude, longitude);
        }
    }
}
