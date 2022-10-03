package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class JdbcConnection {
    public static Connection connectToDatabase() {
        String URL = "jdbc:mysql://localhost:2109/payroll_service";
        String USER = "Nayan soni";
        String PASS = "Nayan99*#";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can't find the driver in the classpath!");
        }

        listDrivers();
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println(driverClass.getClass().getName() + " ");
        }
    }
}
