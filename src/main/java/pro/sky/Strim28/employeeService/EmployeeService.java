package pro.sky.Strim28.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.Strim28.Employee;
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

    public void addEmployee(String firstName, String lastName, String department, Double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }  employees.put(employee.getFullName(), employee);
    }

    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, null, null);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee.getFullName());
        }
    }

    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, null, null);
        if (employees.containsKey(employee.getFullName())) {
            return employee.getFullName();
        } else throw new EmployeeNotFoundException();
    }

    public Collection<Employee> listEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
}