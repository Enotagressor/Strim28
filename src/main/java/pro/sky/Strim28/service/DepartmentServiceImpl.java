package pro.sky.Strim28.service;

import org.springframework.stereotype.Service;
import pro.sky.Strim28.model.Employee;
import pro.sky.Strim28.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee minSalary(String department) {
        return employeeService.listEmployee().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(()-> new EmployeeNotFoundException());
    }
    public Employee maxSalary(String department) {
        return employeeService.listEmployee().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(()-> new EmployeeNotFoundException());
    }

    public List<Employee> allEmployeeDepartment(String department) {
        return employeeService.listEmployee().stream()
                .filter(e -> e.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> listDepartment() {
        return employeeService.listEmployee().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
