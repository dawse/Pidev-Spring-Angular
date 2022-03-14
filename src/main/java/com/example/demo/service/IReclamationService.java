package com.example.demo.service;











import java.util.List;

import com.example.demo.entity.Reclamation;

public interface IReclamationService {

	void save(Reclamation reclamation);

	Reclamation getReclam(Integer id);

	void deleteReclam(Integer id);

	Reclamation UpdateReclam(Reclamation reclamation);

	int NbreReclams();

	List<Reclamation> listAll();

	

	










	






	

	
	


	
}
