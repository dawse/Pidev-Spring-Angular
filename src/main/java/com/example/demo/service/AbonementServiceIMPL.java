package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Abonement;
import com.example.demo.repository.AbonementRepository;

@Service
public class AbonementServiceIMPL implements AbonementService {
	@Autowired
	AbonementRepository flowrepo;

	@Override
	public void save(Abonement abonement) {
	
		flowrepo.save(abonement);
		
	}

	@Override
	public List<Abonement> listAll() {
		
		return (List<Abonement>) flowrepo.findAll();
	}

	@Override
	public Abonement get(Long id) {
		
		return flowrepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		
		flowrepo.deleteById(id);
	}

	@Override
	public Abonement UpdateAbonement(Abonement abonement) {
		Abonement newAbonement = flowrepo.findById(abonement.getId()).get(); 
		newAbonement.setAbonement(abonement.getAbonement());
		newAbonement.setAbonné(abonement.getAbonné());   
		return flowrepo.save(newAbonement);
		
	}

		
	



	

	

}
