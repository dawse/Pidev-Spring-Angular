package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Abonnement;
import com.example.demo.service.AbonnementService;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {
	@Autowired
	AbonnementService abns ; 
///////////////////////////////////////////////
	@PostMapping("/addabonnement")
    public void add(@RequestBody Abonnement abonnement){
		abns.save(abonnement);
		
	}
/////////////////////////////////////
	@DeleteMapping("/Delete-abonnement/{id}")
	public void delete(@PathVariable Long id){
		abns.delete(id);
		
	}
//////////////////////////////////////
	@GetMapping("/liste-abonnement")
	public List<Abonnement> list(){
		return abns.listAll();
	}
//////////////////////////////////
	@GetMapping("/getById/{id}")
    public ResponseEntity<Abonnement> get(@PathVariable Long id){
		try {
			Abonnement abonnement =  abns.get(id); 
		return new ResponseEntity<Abonnement>(abonnement, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Abonnement>(HttpStatus.NOT_FOUND);
		}
		
		
	}
///////////////////////////////////////////////
	 @GetMapping(value="/getNumberabns")
	 @ResponseBody
	 public int getNumberAbonnement(){
		 return abns.getNumberAbonnement();
		 
	 }
	
	
	

}
