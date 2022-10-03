package com.bridgelabz;

import java.sql.SQLException;
public class EmployeePayrollMain {
    public static void main(String[] args) throws EmployeePayrollException, SQLException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        System.out.println("Retrieved data: ");
        employeePayrollService.retrieveData().forEach((System.out::println));

        System.out.println("Update salary: ");
        employeePayrollService.updateSalary("anuj",300000.00);

        System.out.println("Salary between range: ");
        employeePayrollService.getEmployeeBetweenSalaryRange(40000.00,300000.00);

        System.out.println("SUM(salary) of male and female: ");
        employeePayrollService.getSumOfSalaryByMaleAndFemale();

        System.out.println("AVG(salary) of male and female: ");
        employeePayrollService.getAvgOfSalaryByMaleAndFemale();

        System.out.println("MIN(salary) of male and female: ");
        employeePayrollService.getMinOfSalaryByMaleAndFemale();

        System.out.println("MAX(salary) of male and female: ");
        employeePayrollService.getMaxOfSalaryByMaleAndFemale();

        System.out.println("COUNT(salary) of male and female: ");
        employeePayrollService.getCountOfSalaryByMaleAndFemale();

    }
}
