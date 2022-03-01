package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Partagee;

public interface PartageService {
	 void save(Partagee partagee);
		List<Partagee> listAll();
		Partagee get(Long id);
		void delete(Long id);

}
