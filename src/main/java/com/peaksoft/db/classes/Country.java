package com.peaksoft.db.classes;

public class Country {
    private String countryName;
    private int countryId, population;

    public Country(String countryName, int countryId, int population) {
        this.countryName = countryName;
        this.countryId = countryId;
        this.population = population;
    }


    public Country() {
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryId=" + countryId +
                ", population=" + population +
                '}' + "\n";
    }
}
