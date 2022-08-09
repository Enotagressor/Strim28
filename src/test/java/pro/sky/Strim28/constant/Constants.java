package pro.sky.Strim28.constant;

import pro.sky.Strim28.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final String TEST_FIRST_NAME = "Ivan";
    public static final String TEST_LAST_NAME = "Ivanov";
    public static final String TEST_FIRST_NAME2 = "Petr";
    public static final String TEST_LAST_NAME2 = "Petrov";
    public static final String TEST_FIRST_NAME_SMALL_LETTER = "ivan";
    public static final String TEST_LAST_NAME_SMALL_LETTER = "ivanov";
    public static final String TEST_DEPARTMENT1 = "1";
    public static final String TEST_DEPARTMENT2 = "2";
    public static final double TEST_SALARY = 10000.0;
    public static final double TEST_SALARY2 = 12000.0;
    public static final Employee TEST_EMPLOYEE = new Employee("Ivanov", "Ivan", "1", 10000.0);
    public static final Employee TEST_EMPLOYEE2 = new Employee("Petrov", "Petr", "2", 12000.0);
    public static final String INCORRECT_FIRST_NAME = "Ivan351";
    public static final String INCORRECT_LAST_NAME = "Ivanov!!!";
    public static final Collection<Employee> CORRECT_COLLECTION = List.of(
            TEST_EMPLOYEE2,
            TEST_EMPLOYEE
    );
    public static final Collection<Employee> CORRECT_COLLECTION_DEP1 = List.of(
            TEST_EMPLOYEE
    );
    public static final Collection<Employee> EMPTY_COLLECTION = new ArrayList<>();
}
