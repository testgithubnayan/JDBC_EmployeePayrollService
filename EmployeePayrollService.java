package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
    public List<EmployeePayrollData> retrieveData() throws EmployeePayrollException {
        try {
            List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
            Connection connection = JdbcConnection.connectToDatabase();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while (resultSet.next()) {
                employeePayrollDataList.add(new EmployeePayrollData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5)));
            }
            connection.close();
            return employeePayrollDataList;
        } catch (Exception e) {
            throw new EmployeePayrollException();
        }
    }

    public int updateSalary(String name, double salary) throws SQLException {
        Connection connection = JdbcConnection.connectToDatabase();
        PreparedStatement preparedStatement = connection.prepareStatement("update employee_payroll set salary = ? where name = ?");
        preparedStatement.setDouble(1,salary);
        preparedStatement.setString(2,name);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("salary updated successfully!");
        }
        return rowsAffected;
    }

    public void getEmployeeBetweenSalaryRange(double minSalary, double maxSalary) throws SQLException {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        Connection connection = JdbcConnection.connectToDatabase();

        assert connection != null;
        PreparedStatement preparedStatement = connection.prepareStatement(("select * from employee_payroll where salary between ? and ?"));
        preparedStatement.setDouble(1,minSalary);
        preparedStatement.setDouble(2,maxSalary);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            employeePayrollDataList.add(new EmployeePayrollData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDate(5)));
        }
        employeePayrollDataList.forEach(System.out::println);
        connection.close();
    }

    public void getSumOfSalaryByMaleAndFemale() throws SQLException {
        Connection connection = JdbcConnection.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select sum(salary) from employee_payroll where gender = 'F' group by gender");
        System.out.println("Gender count SUM(salary)");
        while (resultSet.next()) {
            System.out.println(resultSet.getDouble(1));
        }
    }

    public void getAvgOfSalaryByMaleAndFemale() throws SQLException {
        Connection connection = JdbcConnection.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select avg(salary) from employee_payroll where gender = 'F' group by gender");
        System.out.println("Gender count AVG(salary)");
        while (resultSet.next()) {
            System.out.println(resultSet.getDouble(1));
        }
    }

    public void getMinOfSalaryByMaleAndFemale() throws SQLException {
        Connection connection = JdbcConnection.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select min(salary) from employee_payroll where gender = 'M' group by gender");
        System.out.println("Gender count MIN(salary)");
        while (resultSet.next()) {
            System.out.println(resultSet.getDouble(1));
        }
    }

    public void getMaxOfSalaryByMaleAndFemale() throws SQLException {
        Connection connection = JdbcConnection.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(salary) from employee_payroll where gender = 'M' group by gender");
        System.out.println("Gender count MAX(salary)");
        while (resultSet.next()) {
            System.out.println(resultSet.getDouble(1));
        }
    }

    public void getCountOfSalaryByMaleAndFemale() throws SQLException {
        Connection connection = JdbcConnection.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(salary) from employee_payroll where gender = 'F' group by gender");
        System.out.println("Gender COUNT(salary)");
        while (resultSet.next()) {
            System.out.println(resultSet.getDouble(1));
        }
    }
}
