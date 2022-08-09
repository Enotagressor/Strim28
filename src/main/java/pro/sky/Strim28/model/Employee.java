package pro.sky.Strim28.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String department;
    private Double salary;

    public Employee(String secondName, String firstName, String department, Double salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(secondName.toLowerCase());
        this.department = department;
        this.salary = salary;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    @Override
    public String toString() {
        return "Employee: " + lastName + " " + firstName + " " + department + " " + salary;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @JsonIgnore
    public  String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}