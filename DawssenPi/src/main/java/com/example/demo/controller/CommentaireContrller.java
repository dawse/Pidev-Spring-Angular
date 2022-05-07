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

import com.example.demo.entity.Commentaire;
import com.example.demo.service.CommentaireService;

@RestController
@RequestMapping("/comment")
public class CommentaireContrller {
	@Autowired
	CommentaireService cmservive ;
//////////////////////////////////
	@PostMapping("/addcomment")
	 public void add(@RequestBody Commentaire commentaire){
		cmservive.save(commentaire);
		
	}
///////////////////////////////////
	@GetMapping("/list-comment")
	public List<Commentaire> list(){
		return cmservive.listAll(); 
		
	}
////////////////////////////////////
	@DeleteMapping("/deletecomment/{id}")
	public ResponseEntity<Commentaire> get(@PathVariable Long id) {
		try {
			Commentaire commentaire = cmservive.get(id);
			return new ResponseEntity<Commentaire>(commentaire, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Commentaire>(HttpStatus.NOT_FOUND);
		}
	}
///////////////////////////////
	@PutMapping(value="/updatecomment")
	@ResponseBody
	public Commentaire UpdateAbonement(@RequestBody Commentaire commentaire){
		return cmservive.UpdateCommentaire(commentaire);
	}
/////////////////////////////////

	@PutMapping("/AffecterPartageACommentaire/{idPartage}/{idCommentaire}")
	@ResponseBody 
	public void AffecterPartageACommentaire(@PathVariable("idPartage")Long idPartage , @PathVariable("idCommentaire") Long idCommentaire){
		cmservive.AffecterPartageACommentaire(idPartage, idCommentaire);
	}
////////////////////////////

	@GetMapping(value="/getNombreCommentaire")
	@ResponseBody
	public int getNumberComment (){
		return cmservive.getNumberComment();
		
	}
///////////////////////////////////
	



	

}
