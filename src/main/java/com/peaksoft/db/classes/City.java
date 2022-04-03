package com.peaksoft.db.classes;

public class City {
    private String cityName;
    private int countryId, cityId;

    public City(String cityName, int countryId, int cityId) {
        this.cityName = cityName;
        this.countryId = countryId;
        this.cityId = cityId;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", countryId=" + countryId +
                ", cityId=" + cityId +
                '}' + "\n";
    }
}
