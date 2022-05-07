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

import com.example.demo.entity.Publicationn;
import com.example.demo.service.PublicationnService;

@RestController
@RequestMapping("/pub")
public class PublicationController {
	@Autowired
	PublicationnService pservice ; 
/////////////////////////////////
	@PostMapping("/addpub")
	 public void add(@RequestBody Publicationn publicationn) {
		pservice.save(publicationn);
	} 
///////////////////////////////////
	@GetMapping("/list-oublication")
	public List<Publicationn> list() {
		return pservice.listAll();
	
	}
///////////////////////////////////
@DeleteMapping("delete-publication/{id}")
public void delete(@PathVariable Long id){
	pservice.delete(id);
	
}
////////////////////////////////////
@GetMapping("/getById/{id}")

	public ResponseEntity<Publicationn> get(@PathVariable Long id) {
	try {
		Publicationn publicationn = pservice.get(id);
		return new ResponseEntity<Publicationn>(publicationn, HttpStatus.OK);
	} catch (NoSuchElementException e) {
		return new ResponseEntity<Publicationn>(HttpStatus.NOT_FOUND);
	}
} 
//////////////////////////////////////
 @PutMapping(value="/updatepub")
 @ResponseBody
public Publicationn UpdatePublication(@RequestBody Publicationn publicationn){
			return pservice.UpdatePublicationn(publicationn);
		} 
/////////////////////////////////////
 @GetMapping("/getByDomaine/{domaine}")

	public List<Publicationn>getPublicationByHashtag(@PathVariable String domaine ){
			return pservice.getPublicationnByDomaine(domaine);
 }
//////////////////////////////////////
 @PutMapping("/AffecterComentaireAPublication/{idCommentaire}/{idPublication}") 
 @ResponseBody
 public void AffecterCommentaireAPublication (@PathVariable("idCommentaire")Long idCommentaire , @PathVariable("idPublication") Long idPublication){
	 pservice.AffecterCommentaireAPublication(idCommentaire, idPublication);
 }
 
/////////////////
 @PutMapping("/AffecterPartageAPublication/{idPartage}/{idPublication}")
 @ResponseBody
 public void AffecterPartageAPublication (@PathVariable("idPartage")Long idPartage , @PathVariable("idPublication") Long idPublication) {
	 pservice.AffecterPartageAPublication(idPartage, idPublication);
 }
 ///////////////////////////////
 @PutMapping("/AffecterLikeAPublication/{idLike}/{idPublication}")
 @ResponseBody
 public void AffecterLikeAPublication(@PathVariable("idLike")Long idLike , @PathVariable("idPublication") Long idPublication){
	 pservice.AffecterLikeAPublication(idLike, idPublication);
 }
////////////////////////////////////
 @PutMapping("/AffecterDislikeAPublication/{iddisLike}/{idPublication}")
 @ResponseBody
 public void AffecterDislikeAPublication(@PathVariable("iddisLike")Long iddisLike , @PathVariable("idPublication") Long idPublication){
	 pservice.AffecterDislikeAPublication(iddisLike, idPublication);
	 
 }
 //////////////////////
	@GetMapping(value="/getNumberpub")
	@ResponseBody
	public int getNumberpub(){
		return pservice.getNumberpub();
	}
/////////////////////////////
	
 
 
 
 
 
 
 
 
 
 
}
