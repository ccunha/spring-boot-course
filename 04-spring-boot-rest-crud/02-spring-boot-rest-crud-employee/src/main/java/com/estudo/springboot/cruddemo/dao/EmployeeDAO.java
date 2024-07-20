package com.estudo.springboot.cruddemo.dao;

import com.estudo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee theEmployee);

    public void deleteById(Employee employee);

}
