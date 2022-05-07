package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Publicationn")

public class Publicationn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 125145L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date ; 
	@Column(name="details")
	private String details ; 
	@Column(name="domaine")
	private String domaine;
	@Enumerated(EnumType.STRING)
	private Type type;
/////////////////////////////////////////////////
	@JsonIgnore
	@OneToMany(mappedBy="publication")
	private List<Commentaire> commentaire ;
////////////////////////////////////////////////
	@JsonIgnore
  	@OneToMany(mappedBy="publication")
	private List<Partage> partage ;
////////////////////////////////////////////////
  	@JsonIgnore
	@OneToOne(mappedBy="publicationn")
	private Like like ;
////////////////////////////////////////////////
  	@JsonIgnore
	@OneToOne(mappedBy="publicationn")
  	private Dislike dislike ; 
////////////////////////////////////////////////

  	
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getDomaine() {
		return domaine;
	}


	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public List<Commentaire> getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}


	public List<Partage> getPartage() {
		return partage;
	}


	public void setPartage(List<Partage> partage) {
		this.partage = partage;
	}


	public Like getLike() {
		return like;
	}


	public void setLike(Like like) {
		this.like = like;
	}


	public Dislike getDislike() {
		return dislike;
	}


	public void setDislike(Dislike dislike) {
		this.dislike = dislike;
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


	public Publicationn(Date date, String details, String domaine, Type type, List<Commentaire> commentaire,
			List<Partage> partage, Like like, Dislike dislike, UserApp userapp) {
		super();
		this.date = date;
		this.details = details;
		this.domaine = domaine;
		this.type = type;
		this.commentaire = commentaire;
		this.partage = partage;
		this.like = like;
		this.dislike = dislike;
		this.userapp = userapp;
	}


	public Publicationn() {
		super();
		// TODO Auto-generated constructor stub
	}


///////////////////////////////////////////////////
  	
  	
  	
  	
  	



}
