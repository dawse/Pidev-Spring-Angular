package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserApp;
import com.example.demo.service.FlowService;

@RestController
@RequestMapping("/Flow")
public class Flow {
	 @Autowired
	 FlowService flw ;
	 @PostMapping("/addflow")
	 private void addRelation(@RequestBody UserApp u1, @RequestBody UserApp u2){
		 flw.addRelation(u1, u2);
		
		 
	 }

}
