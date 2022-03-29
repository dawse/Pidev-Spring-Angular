package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Like;
import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PublicationnRepository;
import com.example.demo.repository.UserRepository;

@Service
public class LikeServiceIMPL implements LikeService {

	@Autowired
	LikeRepository lrepo ;
	@Autowired
	PublicationnRepository preop ;
	@Autowired
	UserRepository usero ;
	@Autowired
	CommentaireRepository crepo ; 
	@Override
	public void save(Like like) {
		lrepo.save(like) ; 	
		
	}

	@Override
	public List<Like> listAll() {
		
		return (List<Like>) lrepo.findAll() ; 
	}

	@Override
	public Like get(Long id) {

		return lrepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		lrepo.deleteById(id);
		
	}

	@Override
	public int getNumberLikes() {
		
		return lrepo.countlk();
	}


}
