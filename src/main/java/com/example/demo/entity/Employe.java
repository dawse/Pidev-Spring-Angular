package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102155L;
 	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom ; 
	private String prenom ;
	private String mail ;
	private String adresse ;
	private int num_tel ; 
	private String sexe ; 
	private int etat ;
	private int cin ;
	private String post ; 
	private String status_civil ;
	@ManyToOne (cascade = CascadeType.ALL)
	private String entreprise ;
	@OneToMany(mappedBy="employe", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Reclamation> reclamation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(int num_tel) {
		this.num_tel = num_tel;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getStatus_civil() {
		return status_civil;
	}
	public void setStatus_civil(String status_civil) {
		this.status_civil = status_civil;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public List<Reclamation> getReclamation() {
		return reclamation;
	}
	public void setReclamation(List<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	



}
