package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Partagee;
import com.example.demo.repository.PartageeRepository;

@Service
public class PartageServiceIMPL implements PartageService { 
	@Autowired
	PartageeRepository prepo ;

	@Override
	public void save(Partagee partagee) {
		prepo.save(partagee) ;
		
		
	}

	@Override
	public List<Partagee> listAll() {
	
		return (List<Partagee>) prepo.findAll();
	}

	@Override
	public Partagee get(Long id) {
	
		return prepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		prepo.deleteById(id);
	
		
	}

	

}
