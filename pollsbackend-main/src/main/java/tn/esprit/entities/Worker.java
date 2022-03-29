package tn.esprit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idWorker")
	private int idWorker;
	
	@Column(nullable = false)
	private String FirstName;
	
	@Column(nullable = false)
	private String LastName;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Column(nullable = false)
	private String Email;
	
	@Column(nullable = false)
	private String numTel;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Demande.class)
	@JoinColumn(name="idDemande", nullable=false)
	private Demande demande;
	
	public int getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(int idWorker) {
		this.idWorker = idWorker;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	
	
	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Worker(int idWorker, String firstName, String lastName, Grade grade, String email, String numTel) {
		super();
		this.idWorker = idWorker;
		FirstName = firstName;
		LastName = lastName;
		this.grade = grade;
		Email = email;
		this.numTel = numTel;
	}

	public Worker() {
		super();
	}
	
	

}
