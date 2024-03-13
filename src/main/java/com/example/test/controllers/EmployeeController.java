package com.example.test.controllers;

import com.example.test.entities.Employee;
import com.example.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllProducts() {
        return employeeService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getProductById(@PathVariable Long id) {
        return employeeService.getProductById(id);
    }

    @PostMapping
    public Employee createProduct(@RequestBody Employee employee) {
        return employeeService.createProduct(employee);
    }

    @PutMapping("/{id}")
    public Employee updateProduct(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateProduct(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        employeeService.deleteProduct(id);
    }
    @GetMapping("/search")
    public List<Employee> search(@RequestParam("name") String name){
        return employeeService.searchProduct(name);
    }


}