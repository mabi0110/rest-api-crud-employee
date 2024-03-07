package com.example.restapicrudemployee.rest.controller;

import com.example.restapicrudemployee.EmployeeNotFoundException;
import com.example.restapicrudemployee.entity.Employee;
import com.example.restapicrudemployee.rest.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
