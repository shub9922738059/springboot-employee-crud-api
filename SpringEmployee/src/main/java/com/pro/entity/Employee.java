package com.pro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;

    @Column(name = "name") 
    private String name;  

    @Column(name = "address") 
    private String address;  

    public Employee() {
        super();
    }

    public Employee(int id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;  
    }

    public void setName(String name) {
        this.name = name;  
    }

    public String getAddress() {
        return address;  
    }

    public void setAddress(String address) {
        this.address = address;  
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}
