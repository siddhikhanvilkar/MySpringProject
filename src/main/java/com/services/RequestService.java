package com.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controllerexp.NullValuesFoundException;
import com.controllerexp.RequestIdNotFoundException;
import com.dao.RequestDao;
import com.model.Employee;
import com.model.Request;

@Service
public class RequestService {
	@Autowired
	RequestDao requestdao;
	
	public String addRequest(Request request) {
		request.setStatus(Request.Statuss.Waiting);
		request.setDate(LocalDate.now());
		requestdao.save(request);
		return "Added request";
	}
	
	public List<Request> getAllrequest(){
		return requestdao.findAll();
	}
//	enum Status { Confirmed ,Waiting ,Rejected }
	public String updateRequest(int requestId,Request.Statuss status) throws RequestIdNotFoundException {
		for(Request r:requestdao.findAll()) {
			if(r.getRequestId()==requestId && r.getRequestType().equals("New Laptop")) {
				r.setStatus(status);
				requestdao.save(r);
				return "updated request";
			}
		}
		throw new RequestIdNotFoundException();
			
	}

	public int findRequestId(int requestId) throws RequestIdNotFoundException {
		for(Request r:requestdao.findAll()) {
			if(r.getRequestId()==requestId ) {
				return 0;
			}
		}
		throw new RequestIdNotFoundException();	
	}
	public int listEmpty(List list) throws NullValuesFoundException {
		if(list.size()!=0) {
		return 0;
		}
		throw new NullValuesFoundException();
	}
}
