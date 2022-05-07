package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Abonee;
import com.example.demo.entity.Abonnement;
import com.example.demo.entity.Publicationn;
import com.example.demo.repository.AboneeRepositroy;
import com.example.demo.repository.AbonementRepository;

@Service
public class AboneeServiceIMPL implements AboneeService {
	@Autowired
	AboneeRepositroy abonnerepo ;
	@Autowired
	AbonementRepository abonrepo ;


	@Override
	public void save(Abonee abonee) {
		abonnerepo.save(abonee) ;
		
	}

	@Override
	public List<Abonee> listAll() {

		return (List<Abonee>) abonnerepo.findAll();
	}

	@Override
	public Abonee get(Long idAbonee) {
	
		return abonnerepo.findById(idAbonee).get();
	}

	@Override
	public void delete(Long idAbonee) {
		abonnerepo.deleteById(idAbonee);
		
	}
	@Transactional
	@Override
	public void ajouterEtAffecterAbonnementAabonne(Abonnement abonnement, List<Long> idAbonne) {

		abonrepo.save(abonnement); 
		for(Long idAbonnes : idAbonne){ 
			Abonee abonee = abonnerepo.findById(idAbonnes).orElse(null);
			abonee.getAbonnement().add(abonnement);
				} 
			}
    @Transactional
	@Override
	public int getNumberAbonne() {

		return abonnerepo.countab();
	}

/*	@Override
	public List<Abonee> getSimilarByDomaine_interet(String domaine_interet) {
		
		return abonnerepo.findByDomaine_interet(domaine_interet) ;
	}*/

	
	






		
	}


