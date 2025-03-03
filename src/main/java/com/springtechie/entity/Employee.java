package com.springtechie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id; // emp_id
    @Column(name = "emp_firstname")
    private String firstName; // emp_firstname
    @Column(name = "emp_lastname")
    private String lastName; // emp_lastname
    @Column(name ="emp_salary" )
    private double salary; // emp_salary

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String firstName, String lastName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {

    }
}
