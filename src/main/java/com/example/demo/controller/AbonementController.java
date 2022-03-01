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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Abonement;
import com.example.demo.service.AbonementService;


@RestController
@RequestMapping("/abonement")
public class AbonementController {
	@Autowired
	AbonementService abservice ; 

	@PostMapping("/addabonement")
	public void add(@RequestBody Abonement abonement) {
			abservice.save(abonement);
		} 
	//////////////////////
		@DeleteMapping ("/Delete-abs/{id}")
		public void delete(@PathVariable Long id) {
			abservice.delete(id);
		}
	/////////////////////
		@GetMapping("/liste_abs")

		  public List<Abonement> list() {
			return abservice.listAll();
		}
	/////////////////////////
		@GetMapping ("/getById/{id}") 
		 public ResponseEntity<Abonement> get(@PathVariable Long id) {
			try {
				Abonement abonement = abservice.get(id);
				return new ResponseEntity<Abonement>(abonement, HttpStatus.OK);
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Abonement>(HttpStatus.NOT_FOUND);
			}
		}
		////////////////////////////////////
		@PutMapping(value="/updateAbonement")
		@ResponseBody
		public Abonement UpdateAbonement(@RequestBody Abonement abonement){
			return abservice.UpdateAbonement(abonement);
		}

	    
	 
		
		




	

}
