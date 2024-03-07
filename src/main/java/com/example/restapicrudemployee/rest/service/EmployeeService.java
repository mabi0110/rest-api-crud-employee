package com.example.restapicrudemployee.rest.service;

import com.example.restapicrudemployee.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();

    Optional<Employee> getEmployeeById(long id);
}
