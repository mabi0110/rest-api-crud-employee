package com.example.restapicrudemployee.rest.service;

import com.example.restapicrudemployee.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();

    Optional<Employee> getEmployeeById(long id);

    Employee saveEmployee(Employee employee);

    Optional<Employee> updateEmployee(long id, Employee employee);

    void deleteEmployeeById(long id);


}
