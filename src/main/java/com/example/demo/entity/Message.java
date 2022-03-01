package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 19547L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ; 
	private String contenue ; 
	private Integer id_employe_envoyee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public Integer getId_employe_envoyee() {
		return id_employe_envoyee;
	}
	public void setId_employe_envoyee(Integer id_employe_envoyee) {
		this.id_employe_envoyee = id_employe_envoyee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Message(String contenue, Integer id_employe_envoyee) {
		super();
		this.contenue = contenue;
		this.id_employe_envoyee = id_employe_envoyee;
	}
	public Message() {
		super();

	}
	


}
