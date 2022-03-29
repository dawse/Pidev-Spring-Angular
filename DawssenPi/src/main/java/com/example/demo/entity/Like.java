package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Like")
public class Like implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1251455L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
//////////////////////////////////////////////////////
	@JsonIgnore
	@OneToOne
	private Publicationn publicationn ;
//////////////////////////////////////////////////////
	@JsonIgnore
	@OneToOne
	private UserApp userapp ;
//////////////////////////////////////////////////////

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Publicationn getPublicationn() {
		return publicationn;
	}
	public void setPublicationn(Publicationn publicationn) {
		this.publicationn = publicationn;
	}
	public UserApp getUserapp() {
		return userapp;
	}
	public void setUserapp(UserApp userapp) {
		this.userapp = userapp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
  	
}
