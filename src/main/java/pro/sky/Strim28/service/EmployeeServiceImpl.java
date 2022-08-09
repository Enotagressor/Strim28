package pro.sky.Strim28.service;

import org.springframework.stereotype.Service;
import pro.sky.Strim28.exception.EmployeeBadRequest;
import pro.sky.Strim28.model.Employee;
import pro.sky.Strim28.exception.EmployeeAlreadyAddedException;
import pro.sky.Strim28.exception.EmployeeNotFoundException;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;


    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();

    }
    public String hello() {
        return "Добро пожаловать в базу данных сотрудников ООО <<РОГА И КОПЫТА>>";
    }

    public Employee addEmployee(String firstName, String lastName, String department, Double salary) {
        legalVoid(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        String key = getKey(firstName, lastName);
        employees.put(key, employee);
        return employee;
    }

    private String getKey(String firstName, String lastName){
        return firstName + " " + lastName;
    }
    public Employee removeEmployee(String firstName, String lastName) {

        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }
    public Employee findEmployee(String firstName, String lastName) {

        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        else {
            throw new EmployeeNotFoundException();
        }
    }

    public Collection<Employee> listEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
    public void legalVoid(String firstName, String lastName){
        if (!isAlpha(firstName) || !isAlpha(lastName)){
            throw new EmployeeBadRequest();
        }
    }
}