package com.pro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.entity.Employee;

import jakarta.persistence.Query;

@Repository
public class EmployeeDao {

    @Autowired
    SessionFactory fact;

    public String insertData(Employee e) {
    	
    	 Session s = null;
    	 Transaction tr= null;
    	 String msg= null;
    	 try {
        s = fact.openSession();
        tr = s.beginTransaction();
        s.persist(e);
        tr.commit();
        msg = "Data inserted successfully";
    	 }
    	 catch(Exception ex) {
    		 if(tr !=null) {
    			 tr.rollback();
    		 }
    		 ex.printStackTrace();
    	 }
    	 
    	 finally {
    		if(s!=null) {
             s.close();
    	     }
    	 }
        return msg;
    }

    
    public String update(Employee e, int id) {
        Session s = fact.openSession();
        Transaction tr = s.beginTransaction();
        Employee e1 = s.get(Employee.class, id);  
        e1.setName(e.getName());
        e1.setAddress(e.getAddress());
        tr.commit();
        s.close();
        return "Data updated successfully";
    }

    
    public String delete(int id) {
        Session s = fact.openSession();
        Transaction tr = s.beginTransaction();
        Employee e1 = s.get(Employee.class, id);  
        s.delete(e1);
        tr.commit();
        s.close();
        return "Data deleted successfully";
    }
    
    public String fetchdata(Employee e, int id) {
      
        Session session = null;
        Transaction  tr= null;
        
        String msg= null;
        try {
        session = fact.openSession(); 
        tr = session.beginTransaction(); 
        String hql = "FROM Employee WHERE id = :id";
        org.hibernate.query.Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("id", id);
        e = query.uniqueResult();  
        System.out.println("ID: " + e.getId());
        System.out.println("Name: " + e.getName());
        System.out.println("Address: " + e.getAddress());
        tr.commit();
        msg = " Employee data fetched successfully";
            
         

         
        } 
        catch(Exception ex) {
        	if(tr !=null) {
        		tr.rollback();
        	}
        	ex.printStackTrace();
        }
            finally {
            	if(session !=null) {
                  session.close();
            	}
            }
			return  msg;
    }
}
          
          
               
         

     
       
       
              
            
        
      
       
          
     
    	
  
