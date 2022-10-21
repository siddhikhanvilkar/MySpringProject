package com.employeelaptoptracking.employeelaptoptracking;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

import com.dao.AdminDao;
import com.dao.RequestDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Admin;
import com.model.Employee;
import com.model.Request;
@SpringBootTest
public class AdminTest {
	Request request=new Request(1,null,"Waiting","New Laptop",LocalDate.now(), null);
	@Autowired
	AdminDao dao1;
	@Autowired
	RequestDao dao;
	Admin admin;
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception{
		
	}
	@BeforeEach
	void setUp() throws Exception{
		admin =new Admin();
	}
	@AfterEach
	void tearDown() throws Exception{
		
	}
	//API
	@Test
    void testGetNewLaptopRequestAdmin() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/getnewlaptoprequestfromadmin";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	@Test
    void testUpdateStatus() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/updatestatus/1/Approved/NewEmployee";
      URI uri=new URI(url);
      HttpHeaders headers = new HttpHeaders();      
      HttpEntity<Request> ht = new HttpEntity<>( headers);
      ResponseEntity<String> res=template.postForEntity(uri,ht,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	//DAO
	@Test
	void testGetNewLaptopRequestAdminD() {
		Request r1=new Request(1,null,"Waiting","New Laptop",LocalDate.now(), null);
		Request r2=new Request(2,null,"Waiting","New Laptop",LocalDate.now(), null);
		List<Request> list=new ArrayList<>();
		list.add(r2);
		list.add(r1);
		for(Request r:list) {
			if(r.getRequestType().equals("New Laptop"))
				dao.save(r);
		}
		long ctr=dao.count();
		Assertions.assertEquals(2, ctr);
	}
	@Test
	void TestUpdateStatusD() {
		request.setStatus("Approved");
		Assertions.assertEquals("Approved",request.getStatus());
	}
}
