package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
public class Entreprise implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identreprise")
	private Long id;
	private String nom;
	private String categorie;
	private String adresse;
	private String contact;
	private String description;
	private String image;
	private String mail;
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Entreprise(Long id, String nom, String categorie, String adresse, String contact, String description,
			String image, String mail, List<Employee> employees, Domaineentity domaine) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.adresse = adresse;
		this.contact = contact;
		this.description = description;
		this.image = image;
		this.mail = mail;
		this.employees = employees;
		Domaine = domaine;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy="entreprise")
	private List<Employee> employees;
	@ManyToOne(cascade = CascadeType.ALL )
	private Domaineentity Domaine;
	
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", adresse=" + adresse
				+ ", contact=" + contact + ", employees=" + employees + ", Domaine=" + Domaine + "]";
	}


	public void setDomaine(Domaineentity domaine) {
		Domaine = domaine;
	}

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
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
		
	public Entreprise(Long id, String nom, String categorie, String adresse, String contact, List<Employee> employees,
			tn.esprit.entities.Domaine domaine, Profession profession, Domaineentity domaine2) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.adresse = adresse;
		this.contact = contact;
		this.employees = employees;
		Domaine = domaine2;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Domaineentity getDomaine() {
		return Domaine;
	}


	public Entreprise(Long id, String nom, String categorie, String adresse, String contact, String description,
			String image, List<Employee> employees, Domaineentity domaine) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.adresse = adresse;
		this.contact = contact;
		this.description = description;
		this.image = image;
		this.employees = employees;
		Domaine = domaine;
	} 
	
	
	
	
}
