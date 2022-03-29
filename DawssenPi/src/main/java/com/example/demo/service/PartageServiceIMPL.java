package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Partage;
import com.example.demo.repository.PartageRepository;

@Service
public class PartageServiceIMPL implements PartageService {
	@Autowired
	PartageRepository prepo ;

	@Override
	public void save(Partage partage) {
		prepo.save(partage);
		
	}

	@Override
	public List<Partage> listAll() {
		
		return (List<Partage>) prepo.findAll();
	}

	@Override
	public Partage get(Long id) {
		
		return prepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		prepo.deleteById(id);
		
	}
	

}
