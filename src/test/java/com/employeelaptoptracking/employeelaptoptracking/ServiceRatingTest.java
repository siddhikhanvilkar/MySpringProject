package com.employeelaptoptracking.employeelaptoptracking;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.EmployeeDao;
import com.dao.ServiceRatingDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Employee;
import com.model.Request;
import com.model.ServiceRating;

@SpringBootTest
public class ServiceRatingTest {
	@Autowired
	ServiceRatingDao dao;
	ServiceRating sr=new ServiceRating();
	//API
//		@Test
//		void testAddServiceRating() throws URISyntaxException, JsonProcessingException {
//		      RestTemplate template=new RestTemplate();
//		      final String url="http://localhost:8080/acceptrating";
//		      URI uri=new URI(url);
//		      HttpHeaders headers = new HttpHeaders();      
//		      HttpEntity<ServiceRating> ht = new HttpEntity<>( headers);
//		      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
//		      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
//			}

	//Dao
	@Test
	void testAddServiceRatingD() {
		sr.setServiceRatingId(1);
		sr.setRating(ServiceRating.Rating.Great);
		dao.save(sr);
		Assertions.assertEquals(sr.getRating(),ServiceRating.Rating.Great);
	}
}
