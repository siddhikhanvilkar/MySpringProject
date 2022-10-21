package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.model.Request;
import com.services.RequestService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Admincontroller {
	@Autowired
	RequestService rservice;
	@GetMapping("/adminhome")
	public String gethome() {
		return "Welcome to Admin Home Page";
	}
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
	public String UpdateStatus(@PathVariable("requestid")int requestid,@PathVariable("status")String status, @PathVariable("reason")String reason) {
		if(rservice.getAllrequestIds(requestid)==0) {
			return "Invalid Request Id";
		}
		rservice.updateRequest(requestid, status);
		return "your request is "+status+" because of "+reason+".";
	}

}
