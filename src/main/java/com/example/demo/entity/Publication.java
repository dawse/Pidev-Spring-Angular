package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Publication")
public class Publication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1145L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date ; 
	@Column(name="source")
	private String source ; 
	@Column(name="details")
	private String details ; 
	@Column(name="like")
	private Integer like ;
	@Column(name="dislike")
	private Integer dislike ;
	@Enumerated(EnumType.STRING)
	private Type type;
	@ManyToMany (cascade = CascadeType.ALL)
	private Set <Commentaire>pub; 
	@ManyToMany (cascade = CascadeType.ALL)
	private Set <Partagee>publication;
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}
	public Integer getDislike() {
		return dislike;
	}
	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Set<Commentaire> getPub() {
		return pub;
	}
	public void setPub(Set<Commentaire> pub) {
		this.pub = pub;
	}
	public Set<Partagee> getPublication() {
		return publication;
	}
	public void setPublication(Set<Partagee> publication) {
		this.publication = publication;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Publication(Date date, String source, String details, Integer like, Integer dislike, Type type,
			Set<Commentaire> pub, Set<Partagee> publication) {
		super();
		this.date = date;
		this.source = source;
		this.details = details;
		this.like = like;
		this.dislike = dislike;
		this.type = type;
		this.pub = pub;
		this.publication = publication;
	}
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
