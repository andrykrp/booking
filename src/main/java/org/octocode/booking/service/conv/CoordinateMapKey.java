package org.octocode.booking.service.conv;

public class CoordinateMapKey {
    int latitude;
    int longitude;

    public CoordinateMapKey(double latitude, double longitude) {
        this.latitude = (int)latitude;
        this.longitude = (int)longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateMapKey)) return false;

        CoordinateMapKey that = (CoordinateMapKey) o;

        return latitude == that.latitude && longitude == that.longitude;

    }

    @Override
    public int hashCode() {
        int result = latitude;
        result = 360 * result + longitude;
        return result;
    }

    @Override
    public String toString() {
        return "[" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                "]";
    }
}
