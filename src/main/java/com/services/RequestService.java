package com.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RequestDao;
import com.model.Employee;
import com.model.Request;

@Service
public class RequestService {
	@Autowired
	RequestDao requestdao;
	
	public String addRequest(Request request) {
		request.setStatus("Waiting");
		request.setDate(LocalDate.now());
		requestdao.save(request);
		return "Added request";
	}
	
	public List<Request> getAllrequest(){
		return requestdao.findAll();
	}
	public String updateRequest(int requestId,String status) {
		for(Request r:requestdao.findAll()) {
			if(r.getRequestId()==requestId && r.getRequestType().equals("New Laptop")) {
				r.setStatus(status);
				requestdao.save(r);
				break;
			}
		}
		return "updated request";
	}
	public int getAllrequestIds(int id){
		
		if(requestdao.findById(id)!=null) {
			return 1;
		}else {
			return 0;
		}
	}
}
