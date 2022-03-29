package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Domaineentity;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Entreprise;

public interface EntrepriseService {
	public Entreprise ajouterEntreprise(Entreprise e);
	public Entreprise modifierEntreprise(Long id ,Entreprise en) ;
	void deleteEntreprise(Long id);
	Entreprise retrieveEntreprise(Long id);
	public List<Employee> RetreiveEmployee(Long idEntreprise);
	public int getNbrEmployees(Long idEntreprise);
	public Domaineentity addDomain(Domaineentity domaine);
	public void setDomain(Long idEntreprise,Domaineentity domain);
	public List<Employee> FilterEmployee(int critere,Long identreprise);
}
