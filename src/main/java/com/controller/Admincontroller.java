package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.controlleradvice.NullValuesAdviceController;
import com.controllerexp.NullValuesFoundException;
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
	public ResponseEntity<List> getNewLaptopRequestsByAdmin(){
		List<Request> list=new ArrayList<>();
		for(Request r:rservice.getAllrequest()) {
			if(r.getRequestType().equals("New Laptop")) {
				list.add(r);
			}
		}
		try {
			rservice.listEmpty(list);
			return new ResponseEntity<List>(list,HttpStatus.OK);

		}catch(NullValuesFoundException e) {
			return new ResponseEntity(e.getClass()+" "+e.toString(),HttpStatus.OK);
		}
	}
	@PostMapping("/updatestatus/{requestid}/{status}/{reason}")
	public ResponseEntity<String> UpdateStatus(@PathVariable("requestid")int requestid,@PathVariable("status")Request.Statuss status, @PathVariable("reason")String reason) {
			try {
				rservice.updateRequest(requestid, status);
				return new ResponseEntity<String>("your request is "+status+" because of "+reason+".",HttpStatus.OK);
			} catch (RequestIdNotFoundException e) {
				// TODO Auto-generated catch block
				return new ResponseEntity<String>( e.getClass()+" "+e.toString(),HttpStatus.OK);
			}
			
		}
		

}
