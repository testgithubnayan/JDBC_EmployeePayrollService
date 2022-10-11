package com.bridgelabz;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/payroll_service";
        String USER = "root";
        String PASS = "nayan@711";

        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find the driver in ths classpath");
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("update employee_payroll set salary=? where name=? ");
            preparedStatement.setDouble(1,150000);
            preparedStatement.setString(2,"Mark");
            preparedStatement.execute();
            ResultSet result = preparedStatement.executeQuery("select * from employee_payroll");
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
