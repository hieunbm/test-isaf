package com.example.test.service;

import com.example.test.entities.Employee;
import com.example.test.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllProducts() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getProductById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createProduct(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateProduct(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null; // Or throw an exception
    }

    public void deleteProduct(Long id) {
        employeeRepository.deleteById(id);
    }
    public List<Employee> searchProduct(String name){
        return employeeRepository.findAllByNameContaining(name);
    }
}
