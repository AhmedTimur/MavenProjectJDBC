package com.peaksoft;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException {

//        System.out.println(DB.getProductsCount());
//        DB.addUser("MacBook", "Apple", 5, 1460.0);

        System.out.println();
        DB.getAllUsers();
        System.out.println();

    }
}
