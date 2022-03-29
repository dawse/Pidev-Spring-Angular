package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Domaineentity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDomaine")
	private Long id ;
	private String value;
	@OneToMany(cascade = CascadeType.ALL , mappedBy="Domaine")
	private List<Entreprise> entreprises;
	
	public Domaineentity(String value) {
		super();
		this.value = value;
	}
	public Domaineentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Entreprise> getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	@Override
	public String toString() {
		return "Domaineentity [id=" + id + ", value=" + value + ", entreprises=" + entreprises + "]";
	}
	public Domaineentity(Long id, String value, List<Entreprise> entreprises) {
		super();
		this.id = id;
		this.value = value;
		this.entreprises = entreprises;
	}
	

}
