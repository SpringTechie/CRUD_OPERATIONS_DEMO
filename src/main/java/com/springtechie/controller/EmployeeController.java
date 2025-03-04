package com.springtechie.controller;

import com.springtechie.entity.Employee;
import com.springtechie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    public String test() {
        return "Hello";
    }

    // to create employee
    @PostMapping("/save")
    public String acceptEmployeeInfo(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // to read data from db
    @GetMapping("/get/id/{id}")
    // http://localhost:8080/get/id/1
    public Employee fetchEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    // to update data
    // if data is present it will update else it will create new object
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/count")
    public long countEmployee() {
        return employeeService.countNoOfRecords();
    }


    @GetMapping("/all")
    public List<Employee> fetchAllEmployees() {
        return employeeService.findAllRecords();
    }

    @PostMapping("/saveall")
    public String saveAllEmployess(@RequestBody List<Employee> employees) {
       return employeeService.saveEmployees(employees);
    }

    // find whether employee exists in DB  based on id;


}
