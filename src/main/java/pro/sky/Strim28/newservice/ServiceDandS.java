package pro.sky.Strim28.newservice;

import org.springframework.stereotype.Service;
import pro.sky.Strim28.Employee;
import pro.sky.Strim28.employeeService.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceDandS {
    private final EmployeeService employeeService;
    public ServiceDandS(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Collection<Employee> listEmployee() {
        List<Employee> employees = employeeService.listEmployee().stream()
                .collect(Collectors.toList());
        return employees;
    }
    public String minSalary(String department) {
        final List<Employee> employeeStream = List.of(listEmployee().stream()
                .filter(employee -> employee.getDepartment().contains(department))
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get());
        return employeeStream.toString();
    }
    public String maxSalary(String department){
        final List<Employee> employeeStream = List.of(listEmployee().stream()
                .filter(employee -> employee.getDepartment().contains(department))
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get());
        return employeeStream.toString();
    }
    public List<Employee> allEmployeeDepartment(String department) {
        final List<Employee> employeeStream = listEmployee().stream()
                .filter(e -> e.getDepartment().contains(department))
                .collect(Collectors.toList());
        return employeeStream;
    }
    public Map<String, List<Employee>> listDepartment() {
        final Map<String, List<Employee>> listOnDep = listEmployee().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
        return listOnDep;
    }
}
