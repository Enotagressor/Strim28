package pro.sky.Strim28.service;

import pro.sky.Strim28.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(String department);

    Employee minSalary(String department);

    Collection<Employee> allEmployeeDepartment(String departmentId);

    Map<String, List<Employee>> listDepartment();
}
