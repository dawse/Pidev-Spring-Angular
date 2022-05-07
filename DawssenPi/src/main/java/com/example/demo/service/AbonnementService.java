package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Abonnement;

public interface AbonnementService {
	void save(Abonnement abonnement);
	List<Abonnement> listAll();
	Abonnement get(Long idAbonnement);
	void delete(Long idAbonnement);
 public int getNumberAbonnement ();

}
