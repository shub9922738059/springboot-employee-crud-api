package com.pro.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.EmployeeDao;
import com.pro.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

  
    public String insertData(Employee e) {
    	
    	String msg = employeeDao.insertData(e);
    	if(Objects.isNull(msg)) {
    		msg = "data not inserted......";
    	}
    	return msg;
    }

 
    public String update(Employee e, int id) {
        return employeeDao.update(e, id);
    }

   
    public String delete(int id) {
        return employeeDao.delete(id);
    }
    
    public String getEmployeeById(Employee e,int id) {
    	String msg = employeeDao.fetchdata(e, id);
    	if(Objects.isNull(msg)) {
    		msg = "data not found in table.......";
    	}
    	return msg;
    }
}
    

