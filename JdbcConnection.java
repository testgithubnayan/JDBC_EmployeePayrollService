package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class JDBCConnection {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/payroll_service";
        String USER = "root";
        String PASS = "Nayan@711";

        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find the driver in ths classpath");
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.execute("update employee_payroll set salary=160000 where name='deniel'");
            ResultSet result = statement.executeQuery("select * from employee_payroll");
            while (result.next()){
                System.out.println(result.getInt("id")+" " +
                        result.getString(2) +" "+
                        result.getDouble(4)+" "+
                        result.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
