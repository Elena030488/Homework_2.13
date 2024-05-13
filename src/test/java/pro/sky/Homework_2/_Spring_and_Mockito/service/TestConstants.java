package pro.sky.Homework_2._Spring_and_Mockito.service;

import pro.sky.Homework_2._Spring_and_Mockito.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TestConstants {
    public static final String FirstName1 = "Ivan";
    public static final String FirstName2 = "ivan23";
    public static final String FirstName3 = "Oleg";
    public static final String LastName1 = "Ivanov";
    public static final String LastName2 = "Petrov";
    public static final int MinSalary = 100;
    public static final int MaxSalary = 1000;
    public static final int DepartmentId1 = 1;
    public static final int DepartmentId2 = 2;
    public static final Employee MinSalaryEmployee = new Employee(FirstName1, LastName1, DepartmentId1, MinSalary);
    public static final Employee MaxSalaryEmployee = new Employee(FirstName1, LastName2, DepartmentId1, MaxSalary);
    public static final Employee MaxSalaryEmployee2 = new Employee(FirstName3, LastName2, DepartmentId2, MaxSalary);
    public static final List<Employee> EMPLOYEES = List.of(MinSalaryEmployee, MaxSalaryEmployee);
    public static final List<Employee> EMPLOYEES2 = List.of(MinSalaryEmployee,MaxSalaryEmployee2);
    public static final Integer DepartmentSalary = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();
    public static final Map<Integer, List<Employee>> EMPLOYEES_OF_ALL_DEPARTMENTS = EMPLOYEES2.stream().collect(groupingBy(Employee::getDepartmentId));
}
