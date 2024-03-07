package com.example.restapicrudemployee.rest.controller;

import com.example.restapicrudemployee.entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    public void loadData() {
        employees = new ArrayList<>();

        employees.add(new Employee("jan", "nowak", "jan@example.com"));
        employees.add(new Employee("ala", "nowak", "ala@example.com"));
        employees.add(new Employee("ela", "nowak", "ela@example.com"));
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employees;
    }
}
