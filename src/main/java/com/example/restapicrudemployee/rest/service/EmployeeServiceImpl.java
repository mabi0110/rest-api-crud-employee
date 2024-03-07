package com.example.restapicrudemployee.rest.service;

import com.example.restapicrudemployee.entity.Employee;
import com.example.restapicrudemployee.rest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(long id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
           return Optional.empty();
        }
        employee.setId(id);
        Employee savedEmployee = employeeRepository.save(employee);
        return Optional.of(savedEmployee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }
}
