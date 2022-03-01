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

import com.example.demo.entity.Publication;
import com.example.demo.service.PublicationService;

@RestController
@RequestMapping("/publication")
public class PublicationController {
	@Autowired
	PublicationService pubservice ; 
	
	@PostMapping ("/addpublication") 
	 public void add(@RequestBody Publication publication) {
		pubservice.save(publication);
	} 
	////////////////////// 
	@GetMapping ("/List-pub")
	public List<Publication> list() {
		return pubservice.listAll();
	}
	/////////////////////
	@DeleteMapping ("/Delete-pub/{id}")
	 	public void delete(@PathVariable Long id) {
		pubservice.delete(id);
	} 
	////////////////////// 
	@GetMapping ("/getById/{id}") 
		public ResponseEntity<Publication> get(@PathVariable Long id) {
		try {
			Publication publication = pubservice.get(id);
			return new ResponseEntity<Publication>(publication, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Publication>(HttpStatus.NOT_FOUND);
		}
	} 
	


	

}
