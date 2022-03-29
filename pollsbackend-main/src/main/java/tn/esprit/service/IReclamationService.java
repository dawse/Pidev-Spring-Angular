package tn.esprit.service;









import tn.esprit.entities.Reclamation;


import java.util.List;

public interface IReclamationService {

	

	
	List<Reclamation> listAll();

	Reclamation get(Long id);
	

	void delete(Long id);


	
	Reclamation Update(Reclamation reclamation);

	


	int NbreReclams();






	void save(Reclamation reclamation, Long EmployeeClaimer, Long EmployeeClaimReiceiver);

	void nbrReclamationParGenre();


	List<Reclamation> getfindbGenre(Reclamation r);













	






	

	
	


	
}
