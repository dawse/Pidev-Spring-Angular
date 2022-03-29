package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Commentaire;
import com.example.demo.entity.Dislike;
import com.example.demo.entity.Like;
import com.example.demo.entity.Partage;
import com.example.demo.entity.Publicationn;
import com.example.demo.entity.UserApp;
import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.DislikeRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PartageRepository;
import com.example.demo.repository.PublicationnRepository;
import com.example.demo.repository.UserRepository;

@Service
public class PublicationnServiceIMPL implements PublicationnService {

	@Autowired
	PublicationnRepository prepo ; 
	@Autowired
	CommentaireRepository crepo ; 
	@Autowired
	PartageRepository parepo ;
	@Autowired
	LikeRepository lrepo ; 
	@Autowired
	DislikeRepository drepo ; 
	@Autowired
	UserRepository urepo ;
	@Override
	public void save(Publicationn publicationn) {
		prepo.save(publicationn) ;
		
	}
    @Transactional
	@Override
	public List<Publicationn> listAll() {
	
		return (List<Publicationn>) prepo.findAll();
	}
    @Transactional
	@Override
	public Publicationn get(Long id) {
		
		return prepo.findById(id).get() ;
	}
    @Transactional
	@Override
	public void delete(Long id) {
		prepo.deleteById(id);

		
	}
    @Transactional
	@Override
	public Publicationn UpdatePublicationn(Publicationn publicationn) {
		Publicationn newPublication = prepo.findById(publicationn.getId()).get(); 
		 newPublication.setDate(publicationn.getDate());
		 newPublication.setDetails(publicationn.getDetails());
		 newPublication.setType(publicationn.getType());
		 return  prepo.save(newPublication); 
	}
    @Transactional
	@Override
	public List<Publicationn> getPublicationnByDomaine(String domaine) {

		return prepo.findByDomaine(domaine) ;
	}
    @Transactional
	@Override
	public void AffecterCommentaireAPublication(Long idCommentaire, Long idPublication) {
		Publicationn publication = prepo.findById(idPublication).get();
		Commentaire commentaire = crepo.findById(idCommentaire).get();
		commentaire.setPublication(publication);
		crepo.save(commentaire) ; 
		
	}
    @Transactional
	@Override
	public void AffecterPartageAPublication(Long idPartage, Long idPublication) {
		Publicationn publication = prepo.findById(idPublication).get();
		Partage partage = parepo.findById(idPartage).get();
		partage.setPublication(publication);
		parepo.save(partage) ;
	}
    @Transactional
	@Override
	public void AffecterLikeAPublication(Long idLike, Long idPublication) {
		Publicationn publicationn = prepo.findById(idPublication).get();
		Like like = lrepo.findById(idLike).get(); 
		like.setPublicationn(publicationn);
		lrepo.save(like); 
			
	}
    @Transactional
	@Override
	public void AffecterDislikeAPublication(Long iddisLike, Long idPublication) {
		Publicationn publicationn = prepo.findById(idPublication).get();
		Dislike dislike =drepo.findById(iddisLike).get(); 
		dislike.setPublicationn(publicationn);
		drepo.save(dislike) ;	
	}
    @Transactional
	@Override
	public int getNumberpub() {
		return prepo.countpub();
	}

	




}
