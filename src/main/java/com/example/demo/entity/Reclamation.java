package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Reclamation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1587L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String reclam ;
	private String nom ;
	private String prenom ;
	private String mail ;
	@Temporal(TemporalType.DATE)
	private Date date_reclam ;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@ManyToOne
	private Employe employe;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReclam() {
		return reclam;
	}
	public void setReclam(String reclam) {
		this.reclam = reclam;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDate_reclam() {
		return date_reclam;
	}
	public void setDate_reclam(Date date_reclam) {
		this.date_reclam = date_reclam;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Employe getEmployee() {
		return employee;
	}
	public void setEmployee(Employe employee) {
		this.employee = employee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Reclamation(String reclam, String nom, String prenom, String mail, Date date_reclam, Genre genre,
			Employe employee) {
		super();
		this.reclam = reclam;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.date_reclam = date_reclam;
		this.genre = genre;
		this.employee = employee;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	


}
