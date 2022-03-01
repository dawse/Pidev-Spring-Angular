package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voyage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 154566L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ; 
	private String destination ; 
	private Date date ; 
	private ObjectVoyage object_voyage; 
	private Integer duree ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ObjectVoyage getObject_voyage() {
		return object_voyage;
	}
	public void setObject_voyage(ObjectVoyage object_voyage) {
		this.object_voyage = object_voyage;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Voyage(String destination, Date date, ObjectVoyage object_voyage, Integer duree) {
		super();
		this.destination = destination;
		this.date = date;
		this.object_voyage = object_voyage;
		this.duree = duree;
	}
	public Voyage() {
		super();
	
	}
	@Override
	public String toString() {
		return "Voyage [id=" + id + ", destination=" + destination + ", date=" + date + ", object_voyage="
				+ object_voyage + ", duree=" + duree + "]";
	}

}
