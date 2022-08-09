package pro.sky.Strim28.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Strim28.exception.EmployeeNotFoundException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.Strim28.constant.Constants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldReturnAllEmployeesByOneDepartment () {
        when(employeeService.listEmployee())
                .thenReturn(CORRECT_COLLECTION);

        assertIterableEquals(CORRECT_COLLECTION_DEP1, out.allEmployeeDepartment("1"));
    }

    @Test
    public void shouldReturnEmptyCollectionWhenDepartmentAbsent () {
        when(employeeService.listEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertIterableEquals(EMPTY_COLLECTION, out.allEmployeeDepartment("3"));
    }

    @Test
    public void shouldReturnMinSalaryEmployeeByDepartment() {
        when(employeeService.listEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(TEST_EMPLOYEE, out.minSalary("1"));
    }

    @Test
    public void shouldReturnMaxSalaryEmployeeByDepartment() {
        when(employeeService.listEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(TEST_EMPLOYEE2, out.maxSalary("2"));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForMinSalaryEmployeeFindingWhenDepartmentAbsent () {
        when(employeeService.listEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertThrows(EmployeeNotFoundException.class,
                () -> out.minSalary("3"));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionForMaxSalaryEmployeeFindingWhenDepartmentAbsent () {
        when(employeeService.listEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertThrows(EmployeeNotFoundException.class,
                () -> out.maxSalary("3"));
    }
}