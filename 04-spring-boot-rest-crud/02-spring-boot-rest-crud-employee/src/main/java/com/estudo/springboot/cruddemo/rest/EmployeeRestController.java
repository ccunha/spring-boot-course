package com.estudo.springboot.cruddemo.rest;

import com.estudo.springboot.cruddemo.dao.EmployeeDAO;
import com.estudo.springboot.cruddemo.entity.Employee;
import com.estudo.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee =  employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee not found!!!");
        }

        return theEmployee;

    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException();
        }

        employeeService.deleteById(tempEmployee);

        System.out.println("Deleted employee with id:" + employeeId);

    }

}
