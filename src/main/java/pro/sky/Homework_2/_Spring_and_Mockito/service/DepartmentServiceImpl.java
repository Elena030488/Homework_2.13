package pro.sky.Homework_2._Spring_and_Mockito.service;


import org.springframework.stereotype.Service;
import pro.sky.Homework_2._Spring_and_Mockito.exceptions.EmployeeNotFoundException;
import pro.sky.Homework_2._Spring_and_Mockito.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }
    @Override
    public Integer getDepartmentSalary(Integer departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Collection<Employee> getEmployee(Integer departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployee() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}

