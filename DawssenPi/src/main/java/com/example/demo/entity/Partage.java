package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Partage")
public class Partage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 125114L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
//////////////////////////////////////////////////////
	@JsonIgnore
	@ManyToOne
	private Publicationn publication ;
//////////////////////////////////////////////////////
	@JsonIgnore
 	@ManyToOne
 	private Commentaire commentaire ;
//////////////////////////////////////////////////////
	@JsonIgnore
 	@ManyToOne
 	private UserApp userapp ;
//////////////////////////////////////////////////////
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Publicationn getPublication() {
		return publication;
	}
	public void setPublication(Publicationn publication) {
		this.publication = publication;
	}
	public Commentaire getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	public UserApp getUserapp() {
		return userapp;
	}
	public void setUserapp(UserApp userapp) {
		this.userapp = userapp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
 	
 	
	



}
