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

import com.example.demo.entity.Like;
import com.example.demo.service.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {
	@Autowired
	LikeService lservice ;
////////////////
	@PostMapping("/addlike")
	public void add(@RequestBody Like like) {
		lservice.save(like);
	} 
/////////////////////////////
	@DeleteMapping("/delete-like/{id}")
	public void delete(@PathVariable Long id){
		lservice.delete(id);
		
	}
//////////////////////////////////
	@GetMapping("/getById/{id}")
	public ResponseEntity<Like> get(@PathVariable Long id) {
		try {
			Like like = lservice.get(id);
			return new ResponseEntity<Like>(like, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Like>(HttpStatus.NOT_FOUND);
		}
	} 
/////////////////////////
@GetMapping(value="/getNombreLikes")
@ResponseBody
public int getNumberLikes (){
return lservice.getNumberLikes();
}


	

}
