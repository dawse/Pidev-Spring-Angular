package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Commentaire;
import com.example.demo.entity.Dislike;
import com.example.demo.entity.Like;
import com.example.demo.entity.Publicationn;
import com.example.demo.entity.UserApp;
import com.example.demo.repository.CommentaireRepository;
import com.example.demo.repository.DislikeRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PublicationnRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	UserRepository urepo ;
	@Autowired
	CommentaireRepository crepo ; 
	@Autowired
	PublicationnRepository prepo ; 
	@Autowired
	LikeRepository lrepo ; 
	@Autowired
	DislikeRepository drepo ; 

	@Override
	public void save(UserApp userapp) {
		urepo.save(userapp);
		
	}

	@Override
	public List<UserApp> listAll() {
		return (List<UserApp>) urepo.findAll();
	}

	@Override
	public UserApp get(Long id) {
		return urepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		urepo.deleteById(id);
		
	}

	@Override
	public UserApp UpdateUser(UserApp userApp) {

		return null;
	}

	@Override
	public void AffecterCommentaireAUser(Long idCommentaire, Long idUser) {
		UserApp user = urepo.findById(idUser).get(); 
		Commentaire commentaire = crepo.findById(idCommentaire).get(); 
		commentaire.setUserapp(user);
		crepo.save(commentaire) ; 
		
		
		
	}

 	@Override
	public void AffecterPublicationAUser(Long idPublication, Long idUser) {
		UserApp user = urepo.findById(idUser).get(); 
		Publicationn publication = prepo.findById(idPublication).get();
		publication.setUserapp(user);//setUserapp(user);
		prepo.save(publication) ;
		
	}

	@Override
	public void AffecterLikeAUser(Long idLike, Long idUser) {
		UserApp user = urepo.findById(idUser).get(); 
		Like like = lrepo.findById(idLike).get(); 
		like.setUserapp(user);
		lrepo.save(like); 
		
	}

	@Override
	public void AffecterDislikeAUser(Long iddisLike, Long idUser) {
		UserApp user = urepo.findById(idUser).get(); 
		Dislike dislike = drepo.findById(iddisLike).get();
		dislike.setUserapp(user);
		drepo.save(dislike);
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*	@Transactional
	@Override
	public void ajouterEtAffecterPublicationAUser(Publicationn publicationn, List<Long> idUser) {

		prepo.save(publicationn) ;
		 for(Long idUsers : idUser){ 
			UserApp user = urepo.findById(idUsers).orElse(null);
			user.getPublicationn().add(publicationn);
			} 
		
		
		
	}*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
