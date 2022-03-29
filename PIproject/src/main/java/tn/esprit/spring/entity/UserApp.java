package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserApp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2077086321655459610L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private Long id ;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	private String nom_Employee;
	private String prenom_Employee;
	
	@Column(nullable = true)
	private Integer experience_Employee;
	@Column(nullable = true)
	private String age_Employee;
	@Column(nullable = true)
	private String telephone_Employee;
	@Column(nullable = true)
	private Long cin_Employee;
	@Column(nullable = true)
	private String adresse_Employee;
	@Column(nullable = true)
	private String email_Employee;
	
	@Column(nullable = true)
	private String nom_Entreprise;
	@Column(nullable = true)
	private String categorie_Entreprise;
	@Column(nullable = true)
	private String adresse_Entreprise;
	@Column(nullable = true)
	private String contact_Entreprise;
	@Column(nullable = true)
	private String email_Entreprise;
	
	@JsonIgnore
	@OneToMany(targetEntity = Demande.class, mappedBy = "userApp", cascade= CascadeType.REMOVE)
	private List<Demande> demandes;
	
	@JsonIgnore
	@OneToMany(targetEntity = Soutretance.class, mappedBy = "userApp", cascade= CascadeType.REMOVE)
	private List<Soutretance> soutretances;

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

	public Integer getExperience_Employee() {
		return experience_Employee;
	}

	public void setExperience_Employee(Integer experience_Employee) {
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

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public List<Soutretance> getSoutretances() {
		return soutretances;
	}

	public void setSoutretances(List<Soutretance> soutretances) {
		this.soutretances = soutretances;
	}

	public UserApp(Long id, String username, String password, String nom_Employee, String prenom_Employee,
			int experience_Employee, String age_Employee, String telephone_Employee, Long cin_Employee,
			String adresse_Employee, String email_Employee, String nom_Entreprise, String categorie_Entreprise,
			String adresse_Entreprise, String contact_Entreprise, String email_Entreprise) {
		super();
		this.id = id;
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
		this.demandes = new ArrayList<Demande>();
		this.soutretances = new ArrayList<Soutretance>();
	}

	public UserApp() {
		super();
		this.demandes = new ArrayList<Demande>();
		this.soutretances = new ArrayList<Soutretance>();
	}

	
	
}