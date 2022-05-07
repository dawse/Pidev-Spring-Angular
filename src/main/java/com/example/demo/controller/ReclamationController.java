package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;








import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Reclamation;
import com.example.demo.service.IReclamationService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/BusinessT")
public class ReclamationController {
	@Autowired
	IReclamationService reclamService;
	
	
	
	@GetMapping("/List-reclam")
	public List<Reclamation> list() {
		return reclamService.listAll();
	}

	
	
	@GetMapping("/getByIdReclam/{id}")
	public ResponseEntity<Reclamation> get(@PathVariable Integer id) {
		try {
			Reclamation reclamation = reclamService.getReclam(id);
			return new ResponseEntity<Reclamation>(reclamation, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Reclamation>(HttpStatus.NOT_FOUND);
		}
	}

	
	
	@PostMapping("/addReclam")
	public void add(@RequestBody Reclamation reclamation ) {
	
	

		
			
	
			reclamService.save(reclamation);

		

	}
	
	
	

	
	
	@PutMapping(value="/updateReclam")

    public Reclamation Update(@RequestBody Reclamation reclamation){
        return  reclamService.UpdateReclam(reclamation);
	}
        
	@DeleteMapping("/Delete-reclam/{id}")
	public void delete(@PathVariable Integer id) {
		reclamService.deleteReclam(id);
	}
	
	@GetMapping("/nbrReclam")
	public int NbreReclams () {
		return reclamService.NbreReclams();
	}
	
	
	

	
	}
