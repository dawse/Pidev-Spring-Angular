package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Boite_chat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 158741L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id_employe1; 
	private Integer id_employe2;
	public Integer getId_employe1() {
		return id_employe1;
	}
	public void setId_employe1(Integer id_employe1) {
		this.id_employe1 = id_employe1;
	}
	public Integer getId_employe2() {
		return id_employe2;
	}
	public void setId_employe2(Integer id_employe2) {
		this.id_employe2 = id_employe2;
	}
	@OneToMany(mappedBy="Boite_chat", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Reclamation> reclamation;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	



}
