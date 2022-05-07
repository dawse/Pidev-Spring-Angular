package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Abonnement;
import com.example.demo.repository.AbonementRepository;

@Service
public class AbonnementServiceIMPL implements AbonnementService {
	@Autowired
	AbonementRepository abnrp;
	@Override
	public void save(Abonnement abonnement) {
		abnrp.save(abonnement) ; 
		
	}

	@Override
	public List<Abonnement> listAll() {
		
		return (List<Abonnement>) abnrp.findAll();
	}

	@Override
	public Abonnement get(Long idAbonnement) {
	
		return abnrp.findById(idAbonnement).get();
	}

	@Override
	public void delete(Long idAbonnement) {
		abnrp.deleteById(idAbonnement);
		
	}

	@Override
	public int getNumberAbonnement() {
		
		return abnrp.countabn();
	}

}
