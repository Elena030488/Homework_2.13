package pro.sky.Homework_2._Spring_and_Mockito.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.Homework_2._Spring_and_Mockito.model.Employee;
import  pro.sky.Homework_2._Spring_and_Mockito.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{departmentId}/salary/max")
    public Employee getEmployeeWithMaxSalary(@PathVariable Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("{departmentId}/salary/min")
    public Employee getEmployeeWithMinSalary(@PathVariable Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("{departmentId}/salary/sum")
    public Integer getDepartmentSalary(@PathVariable Integer departmentId) {
        return departmentService.getDepartmentSalary(departmentId);
    }
    @GetMapping(value = "{departmentId}/employees", params = {"departmentId"})
    public Collection<Employee> getEmployees(@PathVariable Integer departmentId) {
        return departmentService.getEmployee(departmentId);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployee();
    }
}
