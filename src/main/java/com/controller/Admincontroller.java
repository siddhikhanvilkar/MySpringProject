package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.controllerexp.RequestIdNotFoundException;
import com.model.Request;
import com.services.RequestService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Admincontroller {
	@Autowired
	RequestService rservice;
	
	@GetMapping("/getnewlaptoprequestfromadmin")
	public List<Request> getNewLaptopRequestsByAdmin() {
		List<Request> list=new ArrayList<>();
		for(Request r:rservice.getAllrequest()) {
			if(r.getRequestType().equals("New Laptop")) {
				list.add(r);
			}
		}
		return list;
	}
	@PostMapping("/updatestatus/{requestid}/{status}/{reason}")
	public ResponseEntity<String> UpdateStatus(@PathVariable("requestid")int requestid,@PathVariable("status")Request.Statuss status, @PathVariable("reason")String reason) throws RequestIdNotFoundException{
		try{
			rservice.updateRequest(requestid, status);
			return new ResponseEntity<String>("your request is "+status+" because of "+reason+".",HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			throw new RequestIdNotFoundException();
		}
	}

}
