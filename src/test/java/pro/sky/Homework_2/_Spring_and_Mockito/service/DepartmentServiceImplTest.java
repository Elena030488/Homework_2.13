package pro.sky.Homework_2._Spring_and_Mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeNotFoundException;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.Homework_2._Spring_and_Mockito.service.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void shouldGetEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MaxSalaryEmployee, departmentService.getEmployeeWithMaxSalary(DepartmentId1));
    }

    @Test
    void shouldGetEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MinSalaryEmployee, departmentService.getEmployeeWithMinSalary(DepartmentId1));
    }

    @Test
    public void shouldGetDepartmentSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(DepartmentSalary, departmentService.getDepartmentSalary(DepartmentId1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionInGetEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.getEmployeeWithMinSalary(DepartmentId1));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionInGetEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.getEmployeeWithMaxSalary(DepartmentId1));
    }

    @Test
    public void shouldGetEmployeeByDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES2);
        assertEquals(singletonList(MinSalaryEmployee), departmentService.getEmployee(DepartmentId1));
        assertEquals(singletonList(MaxSalaryEmployee2), departmentService.getEmployee(DepartmentId2));
    }


    @Test
    public void shouldGetEmployeesOfAllDepartments() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES2);
        assertEquals(EMPLOYEES_OF_ALL_DEPARTMENTS, departmentService.getEmployee());
    }
}