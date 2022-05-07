package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Graph")
public class Graph implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 125145L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	



}
