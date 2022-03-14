package com.example.demo.entity;

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
	private Integer id;
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
	private Employe claimer;
	
	@ManyToOne
	private Employe claimReceiver;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the reclam
	 */
	public String getReclam() {
		return reclam;
	}

	/**
	 * @param reclam the reclam to set
	 */
	public void setReclam(String reclam) {
		this.reclam = reclam;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the date_reclam
	 */
	public Date getDate_reclam() {
		return date_reclam;
	}

	/**
	 * @param date_reclam the date_reclam to set
	 */
	public void setDate_reclam(Date date_reclam) {
		this.date_reclam = date_reclam;
	}

	/**
	 * @return the claimer
	 */
	public Employe getClaimer() {
		return claimer;
	}

	/**
	 * @param claimer the claimer to set
	 */
	public void setClaimer(Employe claimer) {
		this.claimer = claimer;
	}

	/**
	 * @return the claimReceiver
	 */
	public Employe getClaimReceiver() {
		return claimReceiver;
	}

	/**
	 * @param claimReceiver the claimReceiver to set
	 */
	public void setClaimReceiver(Employe claimReceiver) {
		this.claimReceiver = claimReceiver;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Reclamation(Integer id, String nom, String prenom, String reclam, String mail, Date date_reclam,
			 Employe claimer, Employe claimReceiver) {
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