package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Commentaire;
import com.example.demo.repository.CommentaireRepository;

@Service
public class CommentaireSeviceIMPL implements CommentaireSevice   {
	@Autowired
	CommentaireRepository cmrepo ;

	@Override
	public void save(Commentaire commentaire) {
		cmrepo.save(commentaire);
		
		
	}

	@Override
	public List<Commentaire> listAll() {
		
		return (List<Commentaire>) cmrepo.findAll();
	}

	@Override
	public Commentaire get(Long id) {
		
		return cmrepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		cmrepo.deleteById(id);
	
		
	}


}
