package com.springtechie.service;

import com.springtechie.entity.Employee;
import com.springtechie.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee Saved Successfully";
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    public String updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee updated Successfully";
    }

    public String deleteEmployee(int id) {
      employeeRepository.deleteById(id);
      return "Deleted Successfully";
    }
}
