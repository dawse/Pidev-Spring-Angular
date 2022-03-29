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
import org.springframework.webflow.engine.Flow;

import com.example.demo.entity.Abonee;
import com.example.demo.entity.Abonnement;
import com.example.demo.entity.Publicationn;
import com.example.demo.entity.UserApp;
import com.example.demo.service.AboneeService;
import com.example.demo.service.FlowService;
@RestController
@RequestMapping("/abone")
public class AbonneController {
	@Autowired
	AboneeService abservice ;
////////////////////////////////////////
	
	@PostMapping("/addabonee")
     public void add(@RequestBody Abonee abonee){
		abservice.save(abonee);
		
	}
///////////////////////////////////////
	@DeleteMapping("/Delete-abonne/{id}")
	public void delete(@PathVariable Long id){
		abservice.delete(id);
		
	}
///////////////////////////////////////////
	@GetMapping("/liste-abonne")
	public List<Abonee> list(){
		return abservice.listAll();
	}
/////////////////////////////////////////
	@GetMapping("/getById/{id}")
    public ResponseEntity<Abonee> get(@PathVariable Long id){
		try {
		Abonee abonee =  abservice.get(id); 
		return new ResponseEntity<Abonee>(abonee, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Abonee>(HttpStatus.NOT_FOUND);
		}
		
		
	}
//////////////////////////////

	@PostMapping("/addAbonnement/{idAbonne}")
	public void ajouterEtAffecterAbonnementAabonne(@RequestBody Abonnement abonnement, @PathVariable("idAbonne")List<Long> idAbonne){
		abservice.ajouterEtAffecterAbonnementAabonne(abonnement, idAbonne);
	}
//////////////////////////////

	 @GetMapping(value="/getNumberab")
	 @ResponseBody
	 public int getNumberAbonne(){
		 return abservice.getNumberAbonne();
	 }
///////////////////////////////////
/*	 @Autowired
	 FlowService flw ;
	 @PostMapping("/addflow/{u1}/{u2}")
	 private void addRelation(@RequestBody UserApp u1, @RequestBody UserApp u2){
		 flw.addRelation(u1, u2);
		
		 
	 }*/
	/////////////////////////////
/*
	 @GetMapping("/getByDomaineintrest/{domaine}")
	 public List<Abonee>getSimilarByDomaine_interet(@PathVariable String domaine_interet){
		 return abservice.getSimilarByDomaine_interet(domaine_interet) ;
	 }
	 
*/
	

	
	

	

}
