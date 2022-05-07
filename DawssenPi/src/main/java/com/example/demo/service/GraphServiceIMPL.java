package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.DislikeRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PublicationnRepository;

@Service
public class GraphServiceIMPL implements GraphService {
	@Autowired
	CommentaireRepository crepo ;
	@Autowired
	PublicationnRepository prepo ;
	@Autowired
	LikeRepository lrepo ; 
	@Autowired
	DislikeRepository drepo ;
		@Override
		public int getNumberComment() {
			
			return crepo.countcm();
		}
		@Override
		public int getNumberLikes() {
		
			return lrepo.countlk();
		}
		@Override
		public int getNumberDislike() {
		
			return drepo.countds();
		}
		@Override
		public int getNumberpub() {
		
			return prepo.countpub();
		}
		


}
