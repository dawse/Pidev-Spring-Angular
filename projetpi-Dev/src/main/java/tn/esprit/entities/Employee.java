package tn.esprit.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idemployee")
	private Long id ;
	private String nom;
	private String prenom;
	private int experience;
	private String age;
	private String telephone;
	private long cin;
	private String occupation;
	private String Skills ;
	private String gender ;
    private String country;
    private String Facebook;
	public Employee(Long id, String nom, String prenom, int experience, String age, String telephone, long cin,
			String occupation, String skills, String gender, String country, String adresse, String email,
			Entreprise entreprise, String badge) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.experience = experience;
		this.age = age;
		this.telephone = telephone;
		this.cin = cin;
		this.occupation = occupation;
		Skills = skills;
		this.gender = gender;
		this.country = country;
		this.adresse = adresse;
		this.email = email;
		this.entreprise = entreprise;
		Badge = badge;
	}
	public Employee(Long id, String nom, String prenom, int experience, String age, String telephone, long cin,
			String occupation, String skills, String gender, String country, String facebook, String adresse,
			String email, Entreprise entreprise, String badge) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.experience = experience;
		this.age = age;
		this.telephone = telephone;
		this.cin = cin;
		this.occupation = occupation;
		Skills = skills;
		this.gender = gender;
		this.country = country;
		Facebook = facebook;
		this.adresse = adresse;
		this.email = email;
		this.entreprise = entreprise;
		Badge = badge;
	}
	public String getFacebook() {
		return Facebook;
	}
	public void setFacebook(String facebook) {
		Facebook = facebook;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Employee(Long id, String nom, String prenom, int experience, String age, String telephone, long cin,
			String occupation, String skills, String gender, String adresse, String email, Entreprise entreprise,
			String badge) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.experience = experience;
		this.age = age;
		this.telephone = telephone;
		this.cin = cin;
		this.occupation = occupation;
		Skills = skills;
		this.gender = gender;
		this.adresse = adresse;
		this.email = email;
		this.entreprise = entreprise;
		Badge = badge;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String adresse;
	private String email;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Entreprise entreprise;
	public Employee(Long id, String nom, String prenom, String age, String telephone, long cin, String occupation,
			String skills, String gender, String country, String facebook, String adresse, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.telephone = telephone;
		this.cin = cin;
		this.occupation = occupation;
		Skills = skills;
		this.gender = gender;
		this.country = country;
		Facebook = facebook;
		this.adresse = adresse;
		this.email = email;
	}
	private String Badge ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public long getCin() {
		return cin;
	}
	public void setCin(long cin) {
		this.cin = cin;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public Employee(Long id, String nom, String prenom, int experience, String age, String telephone, long cin,
			String adresse, String email, Entreprise entreprise, String badge) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.experience = experience;
		this.age = age;
		this.telephone = telephone;
		this.cin = cin;
		this.adresse = adresse;
		this.email = email;
		this.entreprise = entreprise;
		Badge = badge;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", experience=" + experience + ", age="
				+ age + ", telephone=" + telephone + ", cin=" + cin + ", adresse=" + adresse + ", email=" + email
				+ ", entreprise=" + entreprise + ", Badge=" + Badge + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Badge == null) ? 0 : Badge.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + (int) (cin ^ (cin >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((entreprise == null) ? 0 : entreprise.hashCode());
		result = prime * result + experience;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBadge() {
		return Badge;
	}
	public void setBadge(String badge) {
		Badge = badge;
	}
	public Employee(String nom, String prenom, String age, String telephone, long cin, String occupation, String skills,
			String gender, String country, String facebook, String adresse, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.telephone = telephone;
		this.cin = cin;
		this.occupation = occupation;
		Skills = skills;
		this.gender = gender;
		this.country = country;
		Facebook = facebook;
		this.adresse = adresse;
		this.email = email;
	}
	
	
	
	
	
}
