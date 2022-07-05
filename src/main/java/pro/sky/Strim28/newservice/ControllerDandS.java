package pro.sky.Strim28.newservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Strim28.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class ControllerDandS {
    private final ServiceDandS serviceDandS;

    public ControllerDandS(ServiceDandS serviceDandS) {
        this.serviceDandS = serviceDandS;
    }
    @GetMapping("/max-salary")
    public String maxSalary(@RequestParam("departmentId") String department) {
        return serviceDandS.maxSalary(department);
    }
    @GetMapping("/min-salary")
    public String minSalary(@RequestParam("departmentId") String department) {
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
