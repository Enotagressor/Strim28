package pro.sky.Strim28.service;

import org.junit.jupiter.api.Test;
import pro.sky.Strim28.exception.EmployeeBadRequest;
import pro.sky.Strim28.exception.EmployeeNotFoundException;
import pro.sky.Strim28.model.Employee;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Strim28.constant.Constants.*;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnRemovedEmployee() {
        out.addEmployee(TEST_LAST_NAME, TEST_FIRST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        Employee result = out.removeEmployee(TEST_LAST_NAME, TEST_FIRST_NAME);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeToRemoveAbsent() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(TEST_LAST_NAME, TEST_FIRST_NAME));
    }

    @Test
    public void shouldReturnAddedEmployee() {
        Employee result = out.addEmployee(TEST_LAST_NAME, TEST_FIRST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldThrowIllegalNameExceptionWhenNameIsNotAlpha() {
        assertThrows(EmployeeBadRequest.class,
                () -> out.addEmployee(INCORRECT_LAST_NAME, INCORRECT_FIRST_NAME, TEST_DEPARTMENT1, TEST_SALARY));
    }

    @Test
    public void shouldReplaceExistingEmployeeWhenNameExists() {
        out.addEmployee(TEST_LAST_NAME, TEST_FIRST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        out.addEmployee(TEST_LAST_NAME, TEST_FIRST_NAME, TEST_DEPARTMENT2, TEST_SALARY);
        assertNotEquals(TEST_DEPARTMENT1, out.findEmployee(TEST_LAST_NAME, TEST_FIRST_NAME).getDepartment());
    }

    @Test
    public void shouldCapitalizeEmployeeName() {
        Employee result = out.addEmployee(TEST_LAST_NAME_SMALL_LETTER, TEST_FIRST_NAME_SMALL_LETTER, TEST_DEPARTMENT1, TEST_SALARY);
        assertEquals(TEST_FIRST_NAME, result.getFirstName());
        assertEquals(TEST_LAST_NAME, result.getLastName());
    }

    @Test
    public void shouldReturnDesiredEmployee() {
        out.addEmployee(TEST_LAST_NAME, TEST_FIRST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        Employee result = out.findEmployee(TEST_LAST_NAME, TEST_FIRST_NAME);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenDesiredEmployeeIsMissing() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(TEST_LAST_NAME, TEST_FIRST_NAME));
    }

    @Test
    public void shouldReturnCorrectCollection() {
        out.addEmployee(TEST_LAST_NAME, TEST_FIRST_NAME, TEST_DEPARTMENT1, TEST_SALARY);
        out.addEmployee(TEST_LAST_NAME2, TEST_FIRST_NAME2, TEST_DEPARTMENT2, TEST_SALARY2);
        Collection<Employee> result = out.listEmployee();
        assertIterableEquals(CORRECT_COLLECTION, result);
    }
}