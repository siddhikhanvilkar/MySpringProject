package com.employeelaptoptracking.employeelaptoptracking;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.model.Employee;
import com.model.Request;
import com.dao.RequestDao;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
public class RequestTest {
	@Autowired
	RequestDao dao;
	Request request=new Request(1,null, "Waiting","New Laptop",LocalDate.now(), null);
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception{
		
	}
	@BeforeEach
	void setUp() throws Exception{
		
	}
	@AfterEach
	void tearDown() throws Exception{
	
	}
	//API
//	@Test
//    void testAddRequest() throws URISyntaxException, JsonProcessingException {
//      RestTemplate template=new RestTemplate();
//      final String url="http://localhost:8080/acceptrequest";
//      URI uri=new URI(url);
//      HttpHeaders headers = new HttpHeaders();      
//      HttpEntity<Request> ht = new HttpEntity<>(request, headers);
//      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
//      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
//	}
	@Test
    void testGetRequest() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/getrequests";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	//DAO
	@Test
	void testAddRequestD() {
		request.setRequestId(1);
		request.setEmpId(null);
		request.setRequestType("New Laptop");
		request.setStatus("Waiting");
		request.setDate(LocalDate.now());
		dao.save(request);
		Request request1=(Request) dao.findById(request.getRequestId()).get();
		Assertions.assertEquals(request.getRequestId(),request1.getRequestId());
	}
	@Test
	void testGetRequestD() {
		Request r1=new Request(1,null,"Waiting","New Laptop",LocalDate.now(), null);
		Request r2=new Request(2,null,"Waiting","New Laptop",LocalDate.now(), null);
		dao.save(r1);
		dao.save(r2);
		long c = dao.count();
		Assertions.assertEquals(2, c);
	}
}
