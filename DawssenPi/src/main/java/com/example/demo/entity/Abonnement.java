package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Abonnement")
public class Abonnement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1251452L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(name="nom")
	private String nom ;
	@Column(name="prenom")
	private String prenom ;
	@Column(name="domaine_interet")
	private String domaine_interet ;
  /*	@JsonIgnore
	@OneToOne(mappedBy="abonnement",cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
  	private Abonee abonee ;*/
  	@JsonIgnore
  	@ManyToMany(mappedBy="abonnement",cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
  	private List<Abonee>abonee;
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
	public List<Abonee> getAbonee() {
		return abonee;
	}
	public void setAbonee(List<Abonee> abonee) {
		this.abonee = abonee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Abonnement(String nom, String prenom, String domaine_interet, List<Abonee> abonee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.domaine_interet = domaine_interet;
		this.abonee = abonee;
	}
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
  	
  	
}
