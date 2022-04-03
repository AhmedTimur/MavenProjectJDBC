package com.peaksoft.db;

import com.peaksoft.db.classes.City;
import com.peaksoft.db.classes.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/country";
    private static final String user = "postgres";
    private static final String password = "237";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public static void addCountry(String countryName, int population) {

        String sql = "insert into country(country_name, population) values(?, ?)";

        try(Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, countryName);
            preparedStatement.setInt(2, population);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAllCountry() {

        String sql = "select * from country";

        try(Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("country_name") + " " +
                        resultSet.getInt("population"));
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAllCity() {

        String sql = "select * from city";

        try(Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                System.out.println(resultSet.getString("city_name") + " " +
                        resultSet.getInt("country_id"));
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void addCity(String cityName, int countryId) {

        String sql = "insert into city(city_name, country_id)" +
                "values(?, ?)";

        try(Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cityName);
            preparedStatement.setInt(2, countryId);
            preparedStatement.executeUpdate();
            System.out.println("Data updated successfully...");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void addMayor(String mayorName, int countryId, int cityId) {

        String sql = "insert into mayor(mayor_name, country_id, city_id) values(?, ?, ?)";

        try(Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, mayorName);
            preparedStatement.setInt(2, countryId);
            preparedStatement.setInt(3, cityId);
            preparedStatement.executeUpdate();
            System.out.println("Data updated successfully...");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Country> getAllCountries() {

        List<Country> countryList = new ArrayList<>();
        String sql = "select * from country";

        try(Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                Country country = new Country();
                country.setCountryId(resultSet.getInt("id"));
                country.setCountryName(resultSet.getString("country_name"));
                country.setPopulation(resultSet.getInt("population"));
                countryList.add(country);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return countryList;
    }

    public static List<City> getAllCities() {

        List<City> cityList = new ArrayList<>();
        String sql = "select * from city";

        try(Connection connection = connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                City city = new City();
                city.setCityName(resultSet.getString("city_name"));
                city.setCityId(resultSet.getInt("id"));
                city.setCountryId(resultSet.getInt("country_id"));
                cityList.add(city);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cityList;
    }

}
