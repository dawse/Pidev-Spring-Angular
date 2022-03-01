package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Abonement;

public interface AbonementService {
	void save(Abonement abonement);
	List<Abonement> listAll();
	Abonement get(Long id);
	void delete(Long id);
	public Abonement UpdateAbonement(Abonement abonement);
	
 

}
