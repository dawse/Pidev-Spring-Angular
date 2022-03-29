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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Dislike;
import com.example.demo.service.DislikeServie;

@RestController
@RequestMapping("/dislike")
public class DislikeController {
	@Autowired
	DislikeServie dser;
/////////////////////////////
	@PostMapping("/adddislike")
	public void add(@RequestBody Dislike dislike) {
		dser.save(dislike);
	} 
/////////////////////////////
	@DeleteMapping("/delete-dislike/{id}")
	public void delete(@PathVariable Long id){
		dser.delete(id);
		
	}
///////////////////////////////
	@GetMapping("/getById/{id}")
	public ResponseEntity<Dislike> get(@PathVariable Long id) {
		try {
			Dislike dislike = dser.get(id);
			return new ResponseEntity<Dislike>(dislike, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Dislike>(HttpStatus.NOT_FOUND);
		}
	} 
	
/////////////////////////////////////
	@GetMapping(value="/getNombreDislike")
	@ResponseBody
	public int getNumberDislike(){
		return dser.getNumberDislike();
	}



	

}
