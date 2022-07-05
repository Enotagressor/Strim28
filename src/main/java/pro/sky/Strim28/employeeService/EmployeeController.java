package pro.sky.Strim28.employeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Strim28.Employee;
import pro.sky.Strim28.exception.EmployeeAlreadyAddedException;
import pro.sky.Strim28.exception.EmployeeStoragesFullException;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String hello() {
        return employeeService.hello();
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName,
                      @RequestParam("department") String department,
                      @RequestParam("salary") Double salary){
        try {
            employeeService.addEmployee(firstName, lastName, department, salary);
            return "Employee added";
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже существует!";
        } catch (EmployeeStoragesFullException e) {
            return "Рабочих мест больше нет, увольте самого бесполезного!";
        }
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "Employee removed";
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/list")
    public Collection<Employee> listEmployee() {
        return employeeService.listEmployee();
    }
}
