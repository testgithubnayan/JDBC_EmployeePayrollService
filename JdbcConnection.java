package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class JDBCConnection {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/payroll_service";
        String USER = "root";
        String PASS = "Yasin@786";

        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find the driver in ths classpath");
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from employee_payroll");
            while (result.next()){
                System.out.println(result.getInt("id")+" " +
                        result.getString(2) +" "+
                        result.getString(3)+ " "+
                        result.getDouble(4)+" "+
                        result.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
