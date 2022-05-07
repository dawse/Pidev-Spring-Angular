package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dislike;
import com.example.demo.repository.DislikeRepository;

@Service
public class DislikeServieIMPL implements DislikeServie {
	@Autowired
	DislikeRepository dislikerepo ; 
	@Override
	public void save(Dislike dislike) {
		dislikerepo.save(dislike) ;
		
		
	}

	@Override
	public List<Dislike> listAll() {
		return (List<Dislike>) dislikerepo.findAll();
	}

	@Override
	public Dislike get(Long id) {

		return dislikerepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		dislikerepo.deleteById(id);
		
	}

	@Override
	public int getNumberDislike() {
		
		return dislikerepo.countds();
	}
}
