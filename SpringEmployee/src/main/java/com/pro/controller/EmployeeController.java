package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pro.entity.Employee;
import com.pro.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public  String addEmployee(@RequestBody  Employee e) {
    	String msg = employeeService.insertData(e);
    	return msg;
        
    }

    @PutMapping("/update/{id}")
    public String  updateEmployee(@RequestBody Employee employee,@PathVariable  int id) {
    	String msg = employeeService.update(employee, id);
    	return msg;
        
    }

   
    @DeleteMapping("/delete/{id}")
    
    public String  DeleteEmployee(Employee employee,@PathVariable  int id) {
    	String msg = employeeService.delete(id);
    	return msg;
    }
    
    @GetMapping("/fetchdata/{id}")
  public String fetchEmp(Employee emp,@PathVariable  int id) {
    	String msg = employeeService.getEmployeeById(emp, id);
    	return msg;
    }
}
