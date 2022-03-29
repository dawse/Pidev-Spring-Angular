package tn.esprit.spring.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Soutretance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSoutretance")
	private int idSoutretance;
	
	@Column(nullable = false)
	private String Titre;
	
	@Column(nullable = false)
	private String Description;

	@Temporal(value = TemporalType.DATE)
	@Column(nullable = false)
	private Date dateLivraisonMax;
	
	@Column(nullable = false)
	private Integer EstimatedTime;
	
	@Column(nullable = false)
	private Integer NbRequired;
	
	@Column(nullable = false)
	private String Price;
	
	@ManyToOne(targetEntity = UserApp.class)
	@JoinColumn(name="idUserApp", nullable=false)
	private UserApp userApp;
	
	@OneToMany(targetEntity = Demande.class, mappedBy = "soutretance", cascade = CascadeType.REMOVE)
	private List<Demande> demandes;

	public int getIdSoutretance() {
		return idSoutretance;
	}

	public void setIdSoutretance(int idSoutretance) {
		this.idSoutretance = idSoutretance;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDateLivraisonMax() {
		return dateLivraisonMax;
	}

	public void setDateLivraisonMax(Date dateLivraisonMax) {
		this.dateLivraisonMax = dateLivraisonMax;
	}

	public Integer getEstimatedTime() {
		return EstimatedTime;
	}

	public void setEstimatedTime(Integer estimatedTime) {
		EstimatedTime = estimatedTime;
	}

	public Integer getNbRequired() {
		return NbRequired;
	}

	public void setNbRequired(Integer nbRequired) {
		NbRequired = nbRequired;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public UserApp getUserApp() {
		return userApp;
	}

	public void setUserApp(UserApp userApp) {
		this.userApp = userApp;
	}
	
	
	@JsonIgnore
	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}


	public Soutretance(int idSoutretance, String titre, String description, Date dateLivraisonMax,
			Integer estimatedTime, Integer nbRequired, String price, UserApp userApp) {
		super();
		this.idSoutretance = idSoutretance;
		Titre = titre;
		Description = description;
		this.dateLivraisonMax = dateLivraisonMax;
		EstimatedTime = estimatedTime;
		NbRequired = nbRequired;
		Price = price;
		this.userApp = userApp;
		this.demandes = new ArrayList<Demande>();
	}

	public Soutretance() {
		super();
		this.demandes = new ArrayList<Demande>();
	}

	
	
	

}
