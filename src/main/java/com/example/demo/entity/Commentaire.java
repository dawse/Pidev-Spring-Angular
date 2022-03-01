package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Commentaire")
public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12145L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ; 
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date ; /////////
	@Column(name="source")
	private String source ; //////////
	@Column(name="contenu")
	private String contenu ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Commentaire(Date date, String source, String contenu) {
		super();
		this.date = date;
		this.source = source;
		this.contenu = contenu;
	}
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
