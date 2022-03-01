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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Partagee;
import com.example.demo.service.PartageService;

@RestController
@RequestMapping("/partage")
public class PartageeController {
	@Autowired
	PartageService parservice ; 
	
	@PostMapping ("/addpartage") 
	 public void add(@RequestBody Partagee partagee) {
		parservice.save(partagee);
	} 
	///////////////////////
	@GetMapping ("/List-part")
	 public List<Partagee> list() {
		return parservice.listAll();
	} 
	////////////////////////
	@DeleteMapping("/Delete-part/{id}")
	public void delete(@PathVariable Long id) {
		parservice.delete(id);
	}
	//////////////////////
	@GetMapping("/getById/{id}")
	  public ResponseEntity<Partagee> get(@PathVariable Long id) {
		try {
			Partagee partagee = parservice.get(id);
			return new ResponseEntity<Partagee>(partagee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Partagee>(HttpStatus.NOT_FOUND);
		}
	}
	 

	

	

}
