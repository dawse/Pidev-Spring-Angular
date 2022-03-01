package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 85452L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ; 
	private String nom ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Room(String nom) {
		super();
		this.nom = nom;
	}
	public Room() {
		super();

	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", nom=" + nom + "]";
	} 
	
	


}
