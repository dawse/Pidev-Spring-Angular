package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Publication;

public interface PublicationService {
	void save(Publication publication);
	List<Publication> listAll();
	Publication get(Long id);
	void delete(Long id);

}
