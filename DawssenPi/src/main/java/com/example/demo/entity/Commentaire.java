package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Commentaire")
public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 125144L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date ;
	@Column(name="contenu")
	private String contenu ;
//////////////////////////////////////////////////////
	@JsonIgnore
	@ManyToOne
	private Publicationn publication ;
//////////////////////////////////////////////////////
	@JsonIgnore
  	@OneToMany(mappedBy="commentaire")
	private List<Partage> partage ;
////////////////////////////////////////////////////////
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
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Publicationn getPublication() {
		return publication;
	}
	public void setPublication(Publicationn publication) {
		this.publication = publication;
	}
	public List<Partage> getPartage() {
		return partage;
	}
	public void setPartage(List<Partage> partage) {
		this.partage = partage;
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
	public Commentaire(Date date, String contenu, Publicationn publication, List<Partage> partage, UserApp userapp) {
		super();
		this.date = date;
		this.contenu = contenu;
		this.publication = publication;
		this.partage = partage;
		this.userapp = userapp;
	}
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}