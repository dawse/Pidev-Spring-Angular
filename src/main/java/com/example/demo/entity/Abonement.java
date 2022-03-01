package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Abonement")
public class Abonement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1214L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ; 
	@Column(name="abonné")
	private String abonné ; 
	@Column(name="abonement")
	private String abonement ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAbonné() {
		return abonné;
	}
	public void setAbonné(String abonné) {
		this.abonné = abonné;
	}
	public String getAbonement() {
		return abonement;
	}
	public void setAbonement(String abonement) {
		this.abonement = abonement;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Abonement(String abonné, String abonement) {
		super();
		this.abonné = abonné;
		this.abonement = abonement;
	}
	public Abonement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
