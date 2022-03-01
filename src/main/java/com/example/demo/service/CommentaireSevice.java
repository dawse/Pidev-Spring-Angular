package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Commentaire;

public interface CommentaireSevice {
	void save(Commentaire commentaire);
	List<Commentaire> listAll();
	Commentaire get(Long id);
	void delete(Long id);

}
