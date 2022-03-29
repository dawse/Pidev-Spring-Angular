package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flow")
public class Flow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1251L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	private UserApp abonne ; 
	private UserApp abonnement ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserApp getAbonne() {
		return abonne;
	}
	public void setAbonne(UserApp abonne) {
		this.abonne = abonne;
	}
	public UserApp getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(UserApp abonnement) {
		this.abonnement = abonnement;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Flow(UserApp abonne, UserApp abonnement) {
		super();
		this.abonne = abonne;
		this.abonnement = abonnement;
	}
	public Flow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flow(Object object, UserApp u1, UserApp u2) {
		// TODO Auto-generated constructor stub
	} 
	
	
	
	

}
