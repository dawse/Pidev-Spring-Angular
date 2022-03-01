package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entreprise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12451L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom ; 
	private String description ; 
	private String categorie ;
	private String login ; 
	private String password ; 
	private String adresse ; 
	private int number ;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="entreprise")
	private List<Employe> employes ; 
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Entreprise(String nom, String description, String categorie, String login, String password, String adresse,
			int number) {
		super();
		this.nom = nom;
		this.description = description;
		this.categorie = categorie;
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.number = number;
	}
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
	

	



}
