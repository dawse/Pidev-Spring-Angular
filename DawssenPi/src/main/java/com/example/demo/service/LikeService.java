package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Like;

public interface LikeService {
	void save(Like like);
	List<Like> listAll();
	Like get(Long id);
	void delete(Long id);
	public int getNumberLikes ();


}
