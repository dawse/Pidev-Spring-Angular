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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="UserApp")
public class UserApp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 125111L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="nom_Employee")
	private String nom_Employee;
	@Column(name="prenom_Employee")
	private String prenom_Employee;
	@Column(name="experience_Employee")
	private int experience_Employee;
	@Column(name="age_Employee")
	private String age_Employee;
	@Column(name="telephone_Employee")
	private String telephone_Employee;
	@Column(name="cin_Employee")
	private Long cin_Employee;
	@Column(name="adresse_Employee")
	private String adresse_Employee;
	@Column(name="email_Employee")
	private String email_Employee;
	@Column(name="nom_Entreprise")
	private String nom_Entreprise;
	@Column(name="categorie_Entreprise")
	private String categorie_Entreprise;
	@Column(name="adresse_Entreprise")
	private String adresse_Entreprise;
	@Column(name="contact_Entreprise")
	private String contact_Entreprise;
	@Column(name="email_Entreprise")
	private String email_Entreprise;
//////////////////////////////////////////////////////
	@JsonIgnore
	@OneToMany(mappedBy ="userapp")
	private List<Commentaire> Commentaire;
//////////////////////////////////////////////////////
	@JsonIgnore
	@OneToMany(mappedBy="userapp",cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
	private List<Publicationn> publicationn ;
//////////////////////////////////////////////////////
	@JsonIgnore
	@OneToOne(mappedBy="userapp")
	private Like like  ;
//////////////////////////////////////////////////////
	@JsonIgnore
	@OneToOne(mappedBy="userapp")
	private Dislike dislike  ;
//////////////////////////////////////////////////////
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom_Employee() {
		return nom_Employee;
	}
	public void setNom_Employee(String nom_Employee) {
		this.nom_Employee = nom_Employee;
	}
	public String getPrenom_Employee() {
		return prenom_Employee;
	}
	public void setPrenom_Employee(String prenom_Employee) {
		this.prenom_Employee = prenom_Employee;
	}
	public int getExperience_Employee() {
		return experience_Employee;
	}
	public void setExperience_Employee(int experience_Employee) {
		this.experience_Employee = experience_Employee;
	}
	public String getAge_Employee() {
		return age_Employee;
	}
	public void setAge_Employee(String age_Employee) {
		this.age_Employee = age_Employee;
	}
	public String getTelephone_Employee() {
		return telephone_Employee;
	}
	public void setTelephone_Employee(String telephone_Employee) {
		this.telephone_Employee = telephone_Employee;
	}
	public Long getCin_Employee() {
		return cin_Employee;
	}
	public void setCin_Employee(Long cin_Employee) {
		this.cin_Employee = cin_Employee;
	}
	public String getAdresse_Employee() {
		return adresse_Employee;
	}
	public void setAdresse_Employee(String adresse_Employee) {
		this.adresse_Employee = adresse_Employee;
	}
	public String getEmail_Employee() {
		return email_Employee;
	}
	public void setEmail_Employee(String email_Employee) {
		this.email_Employee = email_Employee;
	}
	public String getNom_Entreprise() {
		return nom_Entreprise;
	}
	public void setNom_Entreprise(String nom_Entreprise) {
		this.nom_Entreprise = nom_Entreprise;
	}
	public String getCategorie_Entreprise() {
		return categorie_Entreprise;
	}
	public void setCategorie_Entreprise(String categorie_Entreprise) {
		this.categorie_Entreprise = categorie_Entreprise;
	}
	public String getAdresse_Entreprise() {
		return adresse_Entreprise;
	}
	public void setAdresse_Entreprise(String adresse_Entreprise) {
		this.adresse_Entreprise = adresse_Entreprise;
	}
	public String getContact_Entreprise() {
		return contact_Entreprise;
	}
	public void setContact_Entreprise(String contact_Entreprise) {
		this.contact_Entreprise = contact_Entreprise;
	}
	public String getEmail_Entreprise() {
		return email_Entreprise;
	}
	public void setEmail_Entreprise(String email_Entreprise) {
		this.email_Entreprise = email_Entreprise;
	}
	public List<Commentaire> getCommentaire() {
		return Commentaire;
	}
	public void setCommentaire(List<Commentaire> commentaire) {
		Commentaire = commentaire;
	}
	public List<Publicationn> getPublicationn() {
		return publicationn;
	}
	public void setPublicationn(List<Publicationn> publicationn) {
		this.publicationn = publicationn;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserApp(String username, String password, String nom_Employee, String prenom_Employee,
			int experience_Employee, String age_Employee, String telephone_Employee, Long cin_Employee,
			String adresse_Employee, String email_Employee, String nom_Entreprise, String categorie_Entreprise,
			String adresse_Entreprise, String contact_Entreprise, String email_Entreprise,
			List<com.example.demo.entity.Commentaire> commentaire, List<Publicationn> publicationn, Like like,
			Dislike dislike) {
		super();
		this.username = username;
		this.password = password;
		this.nom_Employee = nom_Employee;
		this.prenom_Employee = prenom_Employee;
		this.experience_Employee = experience_Employee;
		this.age_Employee = age_Employee;
		this.telephone_Employee = telephone_Employee;
		this.cin_Employee = cin_Employee;
		this.adresse_Employee = adresse_Employee;
		this.email_Employee = email_Employee;
		this.nom_Entreprise = nom_Entreprise;
		this.categorie_Entreprise = categorie_Entreprise;
		this.adresse_Entreprise = adresse_Entreprise;
		this.contact_Entreprise = contact_Entreprise;
		this.email_Entreprise = email_Entreprise;
		Commentaire = commentaire;
		this.publicationn = publicationn;
		this.like = like;
		this.dislike = dislike;
	}
	public UserApp() {
		super();
		// TODO Auto-generated constructor stub
	}

}
