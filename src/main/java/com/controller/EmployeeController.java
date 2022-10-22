package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.controllerexp.NoDataAddedException;
import com.controllerexp.NullValuesFoundException;
import com.controllerexp.RequestIdNotFoundException;
import com.dao.EmployeeDao;
import com.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	@PostMapping("/acceptemployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) throws NoDataAddedException{
		try {
			if(emp.getName()!=null && emp.getUsername()!=null && emp.getPassword()!=null) {
				dao.save(emp);
				return new ResponseEntity<String>("Employee Accepted.",HttpStatus.OK);
			}else {
				throw new NoDataAddedException();
			}
			
		}catch(NoDataAddedException e) {
			return new ResponseEntity(e.getClass()+" "+e.toString(),HttpStatus.OK);
		}
		
	}
}
