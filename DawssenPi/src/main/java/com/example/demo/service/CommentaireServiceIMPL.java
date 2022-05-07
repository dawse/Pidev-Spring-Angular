package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Commentaire;
import com.example.demo.entity.Partage;
import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PartageRepository;

@Service
public class CommentaireServiceIMPL implements CommentaireService {
	@Autowired
	CommentaireRepository cmrepo ;
	@Autowired
	PartageRepository parepo ;
	@Autowired
	LikeRepository lrepo ;
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

	@Override
	public Commentaire UpdateCommentaire(Commentaire commentaire) {
		Commentaire newCommentaire = cmrepo.findById(commentaire.getId()).get();
		newCommentaire.setContenu(commentaire.getContenu());
		newCommentaire.setDate(commentaire.getDate());
		return cmrepo.save(newCommentaire);
		
		
	}

	@Override
	public void AffecterPartageACommentaire(Long idPartage, Long idCommentaire) {

		Commentaire commentaire = cmrepo.findById(idCommentaire).get(); 
		Partage partage = parepo.findById(idPartage).get();
		partage.setCommentaire(commentaire);
		parepo.save(partage) ;
		
		
		
	}

	@Override
	public int getNumberComment() {
	
		return cmrepo.countcm();
	}

			
	
			
			
		
		
	




}
