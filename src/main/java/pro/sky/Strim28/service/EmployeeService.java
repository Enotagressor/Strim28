package pro.sky.Strim28.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.Strim28.exception.EmployeeBadRequest;
import pro.sky.Strim28.model.Employee;
import pro.sky.Strim28.exception.EmployeeAlreadyAddedException;
import pro.sky.Strim28.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;


    public EmployeeService() {
        this.employees = new HashMap<>();

    }
    public String hello() {
        return "Добро пожаловать в базу данных сотрудников ООО <<РОГА И КОПЫТА>>";
    }

    public Employee addEmployee(String firstName, String lastName, String department, Double salary) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) throw new EmployeeBadRequest();
        String fName = StringUtils.capitalize(firstName);
        String lName = StringUtils.capitalize(lastName);
        Employee employee = new Employee(fName, lName, department, salary);
        String key = getKey(fName, lName);
        if (employees.containsKey(key))  throw new EmployeeAlreadyAddedException();
        employees.put(key, employee);
        return employee;
    }

    private String getKey(String firstName, String lastName){
        return firstName + " " + lastName;
    }
    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) throw new EmployeeNotFoundException();
        return employees.remove(key);
    }
    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) return employees.get(key);
        else throw new EmployeeNotFoundException();
    }

    public Collection<Employee> listEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
}