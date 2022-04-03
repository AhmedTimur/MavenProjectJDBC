package com.peaksoft;

import java.sql.*;

public class DB {

    private static final String url = "jdbc:postgresql://localhost:5432/test";
    private static final String user = "postgres";
    private static final String password = "237";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager. getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }

    public static int getProductsCount() {
        String SQL = "select count(*) from products";
        int count = 0;

        try(Connection conn = connect();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(SQL)) {

            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }

    public static void addUser(String productName, String company, int productCount, double price) {

        String SQL = "insert into products(product_name, company, product_count, price) values(?, ?, ?, ?)";

        try(Connection conn = connect();
        PreparedStatement prSt = conn.prepareStatement(SQL))
        {
        prSt.setString(1, productName);
        prSt.setString(2, company);
        prSt.setInt(3, productCount);
        prSt.setDouble(4, price);
        prSt.executeUpdate();
        }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
    }

    public static void getAllUsers() {
        String SQL = "SELECT * FROM products";

        try(Connection conn = connect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL))
        {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ": " +
                        "Name: " + resultSet.getString("product_name") + ", " +
                        "Company: " + resultSet.getString("company") + ", " +
                        "Quantity: " + resultSet.getInt("product_count") + ", " +
                        "Price: " + resultSet.getDouble("price"));
                System.out.println("**********************************************************************");
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
