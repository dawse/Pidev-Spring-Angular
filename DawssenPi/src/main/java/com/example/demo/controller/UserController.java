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
import com.example.demo.entity.UserApp;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	UserService uservice ; 
//////////////////////////////////
	@PostMapping("/addUser")
	 public void add(@RequestBody UserApp user) {
		uservice.save(user);
	} 
/////////////////////////////////
	@GetMapping("/list-User")
	 public List<UserApp> list() {
		return uservice.listAll();
	} 
////////////////////////////////
	@DeleteMapping("/delete-User/{id}")
	public void delete(@PathVariable Long id) {
		uservice.delete(id);
	} 
//////////////////////////////
	@GetMapping("getById/{id}")
	public ResponseEntity<UserApp> get(@PathVariable Long id) {
		try {
			UserApp user = uservice.get(id);
			return new ResponseEntity<UserApp>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<UserApp>(HttpStatus.NOT_FOUND);
		}
	}
//////////////////////////////////
	@PutMapping(value="/updateuser")
	@ResponseBody
	public UserApp UpdateUser(@RequestBody UserApp user){
		return uservice.UpdateUser(user);
	} 
/////////////////////////////////////////

@PutMapping("/AffecterComentaireAUser/{idCommentaire}/{idUser}")
@ResponseBody
public void AffecterCommentaireAUser (@PathVariable("idCommentaire")Long idCommentaire , @PathVariable("idUser") Long idUser){
	uservice.AffecterCommentaireAUser(idCommentaire, idUser);
}
///////////////////////////////////////////////////////////////////////////////
/*@PutMapping("/AffecterPublicationAUser/{idPublication}/{idUser}")
@ResponseBody
public void AffecterPublicationAUser (@PathVariable("idPublication")Long idPublication , @PathVariable("idUser") Long idUser){
	uservice.AffecterPublicationAUser(idPublication, idUser);
}*/
///////////////////////////////////////////////////////////////////////////////
@PutMapping("/AffecterLikeAUser/{idLike}/{idUser}")
@ResponseBody
public void AffecterLikeAUser (@PathVariable("idLike")Long idLike , @PathVariable("idUser") Long idUser){
	uservice.AffecterLikeAUser(idLike, idUser);
	
}
////////////////////////////////////////////////////
@PutMapping("/AffecterDislikeAUser/{iddisLike}/{idUser}")
@ResponseBody
public void AffecterDislikeAUser(@PathVariable("iddisLike")Long iddisLike , @PathVariable("idUser") Long idUser){
	uservice.AffecterDislikeAUser(iddisLike, idUser);
	
}
////////////////////////////////////////////////////////
/*@PostMapping("/addPublication/{idUser}")
public void ajouterEtAffecterPublicationAUser(@RequestBody Publicationn publicationn, @PathVariable("idUser")List<Long> idUser){
	uservice.ajouterEtAffecterPublicationAUser(publicationn, idUser);
	
	
}*/









}
