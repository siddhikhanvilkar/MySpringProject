package com.model;

import java.util.List;

import javax.persistence.*;

import com.model.Request;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String name;
    private String username;
    private String password;
    private String email;
    private String department;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Request> request;
    private String device;
    
    private String address;
    
    private String complaint;
    public Employee(int empId, String name, String username, String password) {
		super();
		this.empId = empId;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Employee() {
		super();
	}
}
