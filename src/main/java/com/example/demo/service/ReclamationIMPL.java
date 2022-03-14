package com.example.demo.service;


import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reclamation;
import com.example.demo.repository.IReclamationRepository;






@Service

public class ReclamationIMPL implements IReclamationService{

	@Autowired
	IReclamationRepository reclamrepo;
	


	    
	@Override
		public List<Reclamation> listAll() {
		return (List<Reclamation>) reclamrepo.findAll();
	}
	
	
	
	
	@Override
	public void save(Reclamation reclamation) {
		
		
	
		reclamrepo.save(reclamation);

	}
	
	
		
	
	
	@Override
	public Reclamation getReclam (Integer id) {
		return reclamrepo.findById(id).get();
	}
	@Override
	
	public void deleteReclam(Integer id) {
		reclamrepo.deleteById(id);
	}

	@Override
	public Reclamation UpdateReclam(Reclamation reclamation) {
		// TODO Auto-generated method stub
		return reclamrepo.save(reclamation);
				
	}

	@Override
	public int NbreReclams () {
		return ((List<Reclamation>) reclamrepo.findAll()).size();
	}




	
}


	
	


	


	




