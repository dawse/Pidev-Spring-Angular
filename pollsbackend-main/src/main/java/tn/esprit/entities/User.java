package tn.esprit.entities;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.entity.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @Column(nullable=true)
    private String nom_Entreprise;
	@Column(nullable=true)
	private String categorie_Entreprise;
	@Column(nullable=true)
	private String adresse_Entreprise;
	@Column(nullable=true)
	private String contact_Entreprise;
	
	
	
	@Column(nullable=true)
	private String nom_Employee;
	@Column(nullable=true)
	private String prenom_Employee;
	@Column(nullable=true)
	private int experience_Employee;
	@Column(nullable=true)
	private String age_Employee;
	@Column(nullable=true)
	private String telephone_Employee;
	@Column(nullable=true)
	private Long cin_Employee;
	@Column(nullable=true)
	private String adresse_Employee;
	@Column(nullable=true)
	private String email_Employee;
	
	@JsonIgnore
	@OneToMany(mappedBy="claimer", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<Reclamation> reclamation1;
	
	@JsonIgnore
	@OneToMany(mappedBy="claimReceiver", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<Reclamation> reclamation2;
	
	/*@OneToMany(cascade = CascadeType.ALL , mappedBy="entreprise")
	private List<User> employees;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User entreprise;*/
	
	@JsonIgnore
	@OneToMany(targetEntity = Demande.class, mappedBy = "userApp", cascade= CascadeType.REMOVE)
	private List<Demande> demandes;
	
	@JsonIgnore
	@OneToMany(targetEntity = Soutretance.class, mappedBy = "userApp", cascade= CascadeType.REMOVE)
	private List<Soutretance> soutretances;
	
	
	
    public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public List<Soutretance> getSoutretances() {
		return soutretances;
	}

	public void setSoutretances(List<Soutretance> soutretances) {
		this.soutretances = soutretances;
	}

	public String getNom_Entreprise() {
		return nom_Entreprise;
	}

	public void setNom_Entreprise(String nom_Entreprise) {
		this.nom_Entreprise = nom_Entreprise;
	}

	public String getCategorie_Entreprise() {
		return categorie_Entreprise;
	}

	public void setCategorie_Entreprise(String categorie_Entreprise) {
		this.categorie_Entreprise = categorie_Entreprise;
	}

	public String getAdresse_Entreprise() {
		return adresse_Entreprise;
	}

	public void setAdresse_Entreprise(String adresse_Entreprise) {
		this.adresse_Entreprise = adresse_Entreprise;
	}

	public String getContact_Entreprise() {
		return contact_Entreprise;
	}

	public void setContact_Entreprise(String contact_Entreprise) {
		this.contact_Entreprise = contact_Entreprise;
	}

	

	public User(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(String nom_Employee, String prenom_Employee, int experience_Employee, String age_Employee,
			String telephone_Employee, Long cin_Employee, String adresse_Employee, String email_Employee) {
		super();
		this.nom_Employee = nom_Employee;
		this.prenom_Employee = prenom_Employee;
		this.experience_Employee = experience_Employee;
		this.age_Employee = age_Employee;
		this.telephone_Employee = telephone_Employee;
		this.cin_Employee = cin_Employee;
		this.adresse_Employee = adresse_Employee;
		this.email_Employee = email_Employee;
	}

	public User(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			String nom_Employee, String prenom_Employee, int experience_Employee, String age_Employee,
			String telephone_Employee, Long cin_Employee, String adresse_Employee, String email_Employee) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.nom_Employee = nom_Employee;
		this.prenom_Employee = prenom_Employee;
		this.experience_Employee = experience_Employee;
		this.age_Employee = age_Employee;
		this.telephone_Employee = telephone_Employee;
		this.cin_Employee = cin_Employee;
		this.adresse_Employee = adresse_Employee;
		this.email_Employee = email_Employee;
	}

	public String getNom_Employee() {
		return nom_Employee;
	}

	public void setNom_Employee(String nom_Employee) {
		this.nom_Employee = nom_Employee;
	}

	public String getPrenom_Employee() {
		return prenom_Employee;
	}

	public void setPrenom_Employee(String prenom_Employee) {
		this.prenom_Employee = prenom_Employee;
	}

	public int getExperience_Employee() {
		return experience_Employee;
	}

	public void setExperience_Employee(int experience_Employee) {
		this.experience_Employee = experience_Employee;
	}

	public String getAge_Employee() {
		return age_Employee;
	}

	public void setAge_Employee(String age_Employee) {
		this.age_Employee = age_Employee;
	}

	public String getTelephone_Employee() {
		return telephone_Employee;
	}

	public void setTelephone_Employee(String telephone_Employee) {
		this.telephone_Employee = telephone_Employee;
	}

	public Long getCin_Employee() {
		return cin_Employee;
	}

	public void setCin_Employee(Long cin_Employee) {
		this.cin_Employee = cin_Employee;
	}

	public String getAdresse_Employee() {
		return adresse_Employee;
	}

	public void setAdresse_Employee(String adresse_Employee) {
		this.adresse_Employee = adresse_Employee;
	}

	public String getEmail_Employee() {
		return email_Employee;
	}

	public void setEmail_Employee(String email_Employee) {
		this.email_Employee = email_Employee;
	}

	public User() {

    }
	

   /* public User(String nom_Entreprise, String categorie_Entreprise, String adresse_Entreprise,
			String contact_Entreprise) {
		super();
		this.nom_Entreprise = nom_Entreprise;
		this.categorie_Entreprise = categorie_Entreprise;
		this.adresse_Entreprise = adresse_Entreprise;
		this.contact_Entreprise = contact_Entreprise;
		
	}*/

	public User(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			String nom_Entreprise, String categorie_Entreprise, String adresse_Entreprise, String contact_Entreprise
			) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.nom_Entreprise = nom_Entreprise;
		this.categorie_Entreprise = categorie_Entreprise;
		this.adresse_Entreprise = adresse_Entreprise;
		this.contact_Entreprise = contact_Entreprise;
	
	}

	public User(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			String nom_Entreprise, String categorie_Entreprise, String adresse_Entreprise, String contact_Entreprise
		) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.nom_Entreprise = nom_Entreprise;
		this.categorie_Entreprise = categorie_Entreprise;
		this.adresse_Entreprise = adresse_Entreprise;
		this.contact_Entreprise = contact_Entreprise;
		
	}

	

    public User(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, Set<Role> roles,
			String nom_Entreprise, String categorie_Entreprise, String adresse_Entreprise, String contact_Entreprise,
			String nom_Employee, String prenom_Employee, int experience_Employee, String age_Employee,
			String telephone_Employee, Long cin_Employee, String adresse_Employee, String email_Employee,
			List<Reclamation> reclamation1, List<Reclamation> reclamation2) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.nom_Entreprise = nom_Entreprise;
		this.categorie_Entreprise = categorie_Entreprise;
		this.adresse_Entreprise = adresse_Entreprise;
		this.contact_Entreprise = contact_Entreprise;
		this.nom_Employee = nom_Employee;
		this.prenom_Employee = prenom_Employee;
		this.experience_Employee = experience_Employee;
		this.age_Employee = age_Employee;
		this.telephone_Employee = telephone_Employee;
		this.cin_Employee = cin_Employee;
		this.adresse_Employee = adresse_Employee;
		this.email_Employee = email_Employee;
		this.reclamation1 = reclamation1;
		this.reclamation2 = reclamation2;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public List<Reclamation> getReclamation1() {
		return reclamation1;
	}

	public void setReclamation1(List<Reclamation> reclamation1) {
		this.reclamation1 = reclamation1;
	}

	public List<Reclamation> getReclamation2() {
		return reclamation2;
	}

	public void setReclamation2(List<Reclamation> reclamation2) {
		this.reclamation2 = reclamation2;
	}

}
