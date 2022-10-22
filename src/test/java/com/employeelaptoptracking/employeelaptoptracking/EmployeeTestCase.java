package com.employeelaptoptracking.employeelaptoptracking;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Employee;
import com.model.Request;

@SpringBootTest
public class EmployeeTestCase {
	@Autowired
	EmployeeDao dao;
	Employee em=new Employee();
	//API
		@Test
	    void testAddRequest() throws URISyntaxException, JsonProcessingException {
	      RestTemplate template=new RestTemplate();
	      final String url="http://localhost:8080/acceptemployee";
	      URI uri=new URI(url);
	      HttpHeaders headers = new HttpHeaders();      
	      HttpEntity<Employee> ht = new HttpEntity<>(em, headers);
	      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
	      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
		}
	//Dao
	@Test
	void testAddRequestD() {
		em.setEmpId(1);
		em.setName("Siddhi");
		em.setUsername("siddhi");
		em.setPassword("siddhi@123");
		dao.save(em);
		Assertions.assertEquals(em.getEmpId(),1);
	}
}
