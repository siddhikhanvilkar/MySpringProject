package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ServiceRatingDao;
import com.model.ServiceRating;
import com.model.User;

@RestController
public class ServiceRatingController {
	@Autowired
	ServiceRatingDao dao;
	@PostMapping("/acceptrating")
	public String addRating(@RequestBody ServiceRating rating) {
		dao.save(rating);
		return "Rating Accepted";
	}
}
