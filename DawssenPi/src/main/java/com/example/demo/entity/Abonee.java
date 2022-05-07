package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Abonee")
public class Abonee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 125114L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(name="nom")
	private String nom ;
	@Column(name="prenom")
	private String prenom ;
//	private static List<Abonee> flow ;
	@Column(name="domaine_interet")
	private String domaine_interet ;
	/*@JsonIgnore
	@OneToOne
	private Abonnement abonnement ;*/

	@ManyToMany
	@JsonIgnore
	private List<Abonnement >abonnement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDomaine_interet() {
		return domaine_interet;
	}

	public void setDomaine_interet(String domaine_interet) {
		this.domaine_interet = domaine_interet;
	}

	public List<Abonnement> getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(List<Abonnement> abonnement) {
		this.abonnement = abonnement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Abonee(String nom, String prenom, String domaine_interet, List<Abonnement> abonnement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.domaine_interet = domaine_interet;
		this.abonnement = abonnement;
	}

	public Abonee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}