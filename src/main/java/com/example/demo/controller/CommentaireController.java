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

import com.example.demo.entity.Commentaire;
import com.example.demo.service.CommentaireSevice;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
	@Autowired
	CommentaireSevice cmservice ;
	///////////////////
	@PostMapping ("/addcommentaire") 
	 public void add(@RequestBody Commentaire commentaire) {
		cmservice.save(commentaire);
	} 
	///////////////////
	@GetMapping ("/List-cm")
	public List<Commentaire> list() {
		return cmservice.listAll();
	}
	////////////// 
	@DeleteMapping ("/Delete-cm/{id}")
	  public void delete(@PathVariable Long id) {
		cmservice.delete(id);
	}
	/////////////// 
	@GetMapping ("/getById/{id}") 
	 public ResponseEntity<Commentaire> get(@PathVariable Long id) {
		try {
			Commentaire commentaire = cmservice.get(id);
			return new ResponseEntity<Commentaire>(commentaire, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
		}
	}
	
	

	

}
