package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Partage;

public interface PartageService {
	void save(Partage partage);
	List<Partage> listAll();
	Partage get(Long id);
	void delete(Long id);
}
