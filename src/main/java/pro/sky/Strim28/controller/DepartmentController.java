package pro.sky.Strim28.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Strim28.model.Employee;
import pro.sky.Strim28.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService serviceDandS;

    public DepartmentController(DepartmentService serviceDandS) {
        this.serviceDandS = serviceDandS;
    }
    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") String department) {
        return serviceDandS.maxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentId") String department) {
        return serviceDandS.minSalary(department);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> allDep(String departmentId) {
        return serviceDandS.allEmployeeDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<String, List<Employee>> listDepartment() {
        return  serviceDandS.listDepartment();
    }
}
