package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDao;
import com.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	@PostMapping("/acceptemployee")
	public String addEmployee(@RequestBody Employee emp) {
		dao.save(emp);
		return "Employee Accepted";
	}
}
