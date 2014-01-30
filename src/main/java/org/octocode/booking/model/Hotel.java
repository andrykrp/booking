package org.octocode.booking.model;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */
public class Hotel {
    private Long hotelId;
    private Long chainId;
    private String chainName;
    private Long brandId;
    private String brandName;
    private String hotelName;
    private String hotelFormelyName;
    private String hotelTranslatedName;
    private String addressLine1;
    private String addressLine2;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String countryIsoCode;
    private Integer starRating;
    private Long longitude;
    private Long latitude;
    private String url;
    private String checkin;
    private String checkout;
    private Integer numberRooms;
    private Integer numberFloors;
    private String yearOpened;
    private String yearRenovated;
    private List<String> photos;
    private String overview;
    private String ratesFrom;
    private Long continentId;
    private String continentName;
    private Long cityId;
    private Long countryId;
    private Integer numberOfReviews;
    private Integer ratingAverage;
    private Integer ratesCurrency;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelFormelyName() {
        return hotelFormelyName;
    }

    public void setHotelFormelyName(String hotelFormelyName) {
        this.hotelFormelyName = hotelFormelyName;
    }

    public String getHotelTranslatedName() {
        return hotelTranslatedName;
    }

    public void setHotelTranslatedName(String hotelTranslatedName) {
        this.hotelTranslatedName = hotelTranslatedName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Integer getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(Integer numberRooms) {
        this.numberRooms = numberRooms;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getYearOpened() {
        return yearOpened;
    }

    public void setYearOpened(String yearOpened) {
        this.yearOpened = yearOpened;
    }

    public String getYearRenovated() {
        return yearRenovated;
    }

    public void setYearRenovated(String yearRenovated) {
        this.yearRenovated = yearRenovated;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRatesFrom() {
        return ratesFrom;
    }

    public void setRatesFrom(String ratesFrom) {
        this.ratesFrom = ratesFrom;
    }

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Integer getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Integer ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Integer getRatesCurrency() {
        return ratesCurrency;
    }

    public void setRatesCurrency(Integer ratesCurrency) {
        this.ratesCurrency = ratesCurrency;
    }
}
