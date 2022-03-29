package com.example.demo.controller;

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

import com.example.demo.entity.Partage;
import com.example.demo.service.PartageService;

@RestController
@RequestMapping("/share")
public class PartageController {
	@Autowired
	PartageService pservice ;
/////////////////////////////
	@PostMapping("/aadshare")
	public void add(@RequestBody Partage partage) {
		pservice.save(partage);
	} 
////////////////////////////
	@DeleteMapping("/delete-share/{id}")
	public void delete(@PathVariable Long id){
		pservice.delete(id);
		
	}
/////////////////////////
	@GetMapping("/getById/{id}")
	public ResponseEntity<Partage> get(@PathVariable Long id) {
		try {
			Partage partage = pservice.get(id);
			return new ResponseEntity<Partage>(partage, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Partage>(HttpStatus.NOT_FOUND);
		}
	} 
	




}
