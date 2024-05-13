package pro.sky.Homework_2._Spring_and_Mockito.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeIncorrectDataException;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeNotFoundException;
import pro.sky.Homework_2._Spring_and_Mockito.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements pro.sky.Homework_2._Spring_and_Mockito.service.EmployeeService {
    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
    //    add("Irina", "Ivanova");
    //    add("Irina", "Petrova");
    //    add("Irina", "Frolova");
    //    add("Irina", "Voronova");
    //    add("Ivan", "Ivanov");
    //    add("Ivan", "Petrov");
    //    add("Ivan", "Frolov");
    //    add("Ivan", "Voronov");
    }

    @Override
    public Employee add(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employeeList.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        validate(firstName, lastName);
        Employee employee = new Employee(firstName, lastName);
        employeeList.put(key, employee);
        return employee;
    }
    @Override
    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        String key = getKey(firstName, lastName);
        if (employeeList.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        validate(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        employeeList.put(key, employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employeeList.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудника не существует");
        }
        Employee employee = new Employee(firstName, lastName);
        employeeList.remove(key);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employeeList.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудника не существует");
        }
        return employeeList.get(key);
    }

    @Override
    public Collection<Employee> findAll() {
        return new ArrayList<>(employeeList.values());
    }

    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name) || !StringUtils.isAlpha(name)) {
            throw new EmployeeIncorrectDataException("Некорректное имя");
        }
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
