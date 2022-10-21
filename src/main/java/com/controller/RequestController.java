package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDao;
import com.dao.RequestDao;
import com.dao.UserDao;
import com.model.AuthenticateRequest;
import com.model.Employee;
import com.model.Request;
import com.model.User;
import com.services.RequestService;

@RestController
public class RequestController {
	@Autowired
	RequestService rservice;
	@Autowired
	EmployeeDao userDao;
	@Autowired
	RequestDao dao;
	@GetMapping("/getrequests")
	public List<Request> getRequests(){
		return rservice.getAllrequest();
	}
	@PostMapping("/addrequest")
    public ResponseEntity<?> addRequest(@RequestBody AuthenticateRequest authenticate)
    {
        String username= authenticate.getUser().getUsername();
        String password= authenticate.getUser().getPassword();
       Employee userexists=(Employee) userDao.findByUsername(username);

        if(userexists.getUsername().equals(username) && userexists.getPassword().equals(password))
       {
       Request request=authenticate.getRequest();
       rservice.addRequest(request);
          return new ResponseEntity<>("Request added successfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("User not found",HttpStatus.OK);
       }

    }
}
