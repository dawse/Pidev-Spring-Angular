package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Commentaire;


public interface CommentaireService {
	void save(Commentaire commentaire);
	List<Commentaire> listAll();
	Commentaire get(Long id);
	void delete(Long id);
	public Commentaire UpdateCommentaire(Commentaire commentaire); 
	public void AffecterPartageACommentaire (Long idPartage , Long idCommentaire ) ; 
	public int getNumberComment ();


}
