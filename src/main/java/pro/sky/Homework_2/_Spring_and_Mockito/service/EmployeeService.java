package pro.sky.Homework_2._Spring_and_Mockito.service;

import pro.sky.Homework_2._Spring_and_Mockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee add(String firstName, String lastName, int departmentId, int salary);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
    void validate(String firstName, String lastName);
}
