package com.example.restapicrudemployee.rest.controller;

import com.example.restapicrudemployee.EmployeeNotFoundException;
import com.example.restapicrudemployee.entity.Employee;
import com.example.restapicrudemployee.rest.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with ID: " + id + " not found"));
    };

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee).orElseThrow(() ->
                new EmployeeNotFoundException("Employee with ID: " + id + " not found"));
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }




}
