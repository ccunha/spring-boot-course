package com.estudo.springboot.cruddemo.service;

import com.estudo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee theEmployee);

    public void deleteById(Employee employee);


}
