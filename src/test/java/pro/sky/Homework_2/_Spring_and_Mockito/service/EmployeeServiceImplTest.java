package pro.sky.Homework_2._Spring_and_Mockito.service;

import org.junit.jupiter.api.Test;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeIncorrectDataException;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeNotFoundException;
import pro.sky.Homework_2._Spring_and_Mockito.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Homework_2._Spring_and_Mockito.service.TestConstants.*;


class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployee() {
        assertEquals(0, employeeService.findAll().size());
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, DepartmentId1, MinSalary);
        assertEquals(1, employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        employeeService.add(FirstName1, LastName1, DepartmentId1, MinSalary);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FirstName1, LastName1, DepartmentId1, MinSalary));
    }

    @Test
    public void shouldThrowEmployeeIncorrectDataException() {
        assertThrows(EmployeeIncorrectDataException.class,
                () -> employeeService.validate(FirstName2, LastName1));
    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, DepartmentId1, MinSalary);
        employeeService.remove(FirstName1, LastName1);
        assertFalse(employeeService.findAll().contains(addedEmployee));
    }
    @Test
    public void shouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(FirstName1, LastName1));
    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, DepartmentId1, MinSalary);
        assertEquals(addedEmployee, employeeService.find(FirstName1, LastName1));
    }
    @Test
    public void shouldFindNotAddedEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(FirstName1, LastName1));
    }

    @Test
    public void shoulsFindAllEmployees() {
        assertEquals(0, employeeService.findAll().size());
        Employee addedEmployee1 = employeeService.add(FirstName1, LastName1, DepartmentId1, MinSalary);
        Employee addedEmployee2 = employeeService.add(FirstName1, LastName2, DepartmentId1, MinSalary);
        Collection<Employee> addedEmployees = employeeService.findAll();
        assertEquals(2, employeeService.findAll().size());
        assertIterableEquals(List.of(addedEmployee1, addedEmployee2), addedEmployees);
    }

    @Test
    void validate() {
    }
}