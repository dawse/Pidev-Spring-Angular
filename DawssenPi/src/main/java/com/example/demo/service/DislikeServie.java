package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Dislike;

public interface DislikeServie {
	void save(Dislike dislike);
	List<Dislike> listAll();
	Dislike get(Long id);
	void delete(Long id);
	public int getNumberDislike();
}
