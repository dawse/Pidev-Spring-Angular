package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Abonee;
import com.example.demo.entity.Abonnement;


public interface AboneeService {
	void save(Abonee abonee);
	List<Abonee> listAll();
	Abonee get(Long idAbonee);
	void delete(Long idAbonee);
 void ajouterEtAffecterAbonnementAabonne(Abonnement abonnement, List<Long> idAbonne);
 public int getNumberAbonne ();
// List<Abonee> getSimilarByDomaine_interet(String domaine_interet);


}
