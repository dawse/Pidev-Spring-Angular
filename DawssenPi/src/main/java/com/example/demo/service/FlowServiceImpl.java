package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Flow;
import com.example.demo.entity.UserApp;

import com.example.demo.repository.FlowRepo;

@Service
public class FlowServiceImpl implements FlowService {
@Autowired
FlowRepo fw ;
	@Override
	public void addRelation(UserApp u1, UserApp u2) {
		Flow f = new Flow(null, u1,u2 ) ; 
		fw.save(f) ; 
		
		
		
	}

}
