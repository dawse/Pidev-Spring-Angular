package tn.esprit.entities;

import java.io.Serializable;







import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;






@Entity


	public class  Reclamation implements Serializable {

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String reclam;
	@Column
	private String mail;
	@Column
	@Temporal(TemporalType.DATE)
	
	private Date date_reclam;

	
	@ManyToOne
	private User claimer;
	
	@ManyToOne
	private User claimReceiver;

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

	public String getReclam() {
		return reclam;
	}

	public void setReclam(String reclam) {
		this.reclam = reclam;
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

	public User getClaimer() {
		return claimer;
	}

	public void setClaimer(User claimer) {
		this.claimer = claimer;
	}

	public User getClaimReceiver() {
		return claimReceiver;
	}

	public void setClaimReceiver(User claimReceiver) {
		this.claimReceiver = claimReceiver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation(Long id, String nom, String prenom, String reclam, String mail, Date date_reclam, User claimer,
			User claimReceiver) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.reclam = reclam;
		this.mail = mail;
		this.date_reclam = date_reclam;
		this.claimer = claimer;
		this.claimReceiver = claimReceiver;
	}
	




	
	

	
}