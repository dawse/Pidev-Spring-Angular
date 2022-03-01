package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Partage")
public class Partagee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1244L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	@ManyToMany(mappedBy="publication",cascade = CascadeType.ALL)
	private Set <Publication>publications;

	

}
