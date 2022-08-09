package pro.sky.Strim28.service;

import pro.sky.Strim28.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    String hello();

    Employee addEmployee(String firstName, String lastName, String department, Double salary);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> listEmployee();
}
