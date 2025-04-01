package com.springtechie.controller;

import com.springtechie.entity.Employee;
import com.springtechie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @Autowired
//    public void setEmployeeService(EmployeeService employeeService) {
//        System.out.println("Hello DI using Setter");
//        this.employeeService = employeeService;
//    }

    @Autowired
    public EmployeeController(@Autowired EmployeeService employeeService) {
        System.out.println("Hello DI using Cons");
        System.out.println(employeeService.hashCode());
        this.employeeService = employeeService;
    }


    // to create employee
    @PostMapping("/save")
    public ResponseEntity<String> acceptEmployeeInfo(@RequestBody Employee employee) {

        Employee employee1 = employeeService.saveEmployee(employee);
        if(employee1 != null) {
            return new ResponseEntity<>("Employee Saved Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Employee failed to save",HttpStatus.BAD_REQUEST);
    }

    // to read data from db
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if(employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
