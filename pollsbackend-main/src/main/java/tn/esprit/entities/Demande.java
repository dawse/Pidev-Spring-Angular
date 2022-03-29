package tn.esprit.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Demande {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDemande")
	private Integer idDemande;
	
	@Column(nullable = false)
	private Integer estimadeTime;
	
	@Column(nullable = false)
	private Date dateDebut;
	
	@Column(nullable = false)
	private Date dateFin;
	
	@OneToMany(targetEntity = Worker.class, mappedBy = "demande", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Worker> workers;
	
	@JsonIgnore
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="idUser", nullable=false)
	private User userApp;
	
	@ManyToOne(targetEntity = Soutretance.class)
	@JoinColumn(name="idSoutretance", nullable=false)
	private Soutretance soutretance;
	
	@Transient
	private long score;

	public Integer getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(Integer idDemande) {
		this.idDemande = idDemande;
	}

	public Integer getEstimadeTime() {
		return estimadeTime;
	}

	public void setEstimadeTime(Integer estimadeTime) {
		this.estimadeTime = estimadeTime;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public User getUserApp() {
		return userApp;
	}

	public void setUserApp(User userApp) {
		this.userApp = userApp;
	}

	public Soutretance getSoutretance() {
		return soutretance;
	}

	public void setSoutretance(Soutretance soutretance) {
		this.soutretance = soutretance;
	}
	
	

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public Demande(int idDemande, Integer estimadeTime, Date dateDebut, Date dateFin,
			User userApp, Soutretance soutretance) {
		super();
		this.idDemande = idDemande;
		this.estimadeTime = estimadeTime;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.workers = new ArrayList<Worker>();
		this.userApp = userApp;
		this.soutretance = soutretance;
	}

	public Demande() {
		super();
		this.workers = new ArrayList<Worker>();
	}
	
	

}
