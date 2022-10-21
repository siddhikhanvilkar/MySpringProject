package com.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.controllerexp.RequestIdNotFoundException;
import com.dao.ServiceRatingDao;
import com.model.ServiceRating;


@RestController
public class ServiceRatingController {
	@Autowired
	ServiceRatingDao dao;
	@PostMapping("/acceptrating")
	public ResponseEntity<String> addRating(@RequestBody ServiceRating rating) throws RequestIdNotFoundException{
		try{
			dao.save(rating);
			return new ResponseEntity<String>("Rating Accepted successfully",HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			throw new RequestIdNotFoundException();
		}
	}
}
