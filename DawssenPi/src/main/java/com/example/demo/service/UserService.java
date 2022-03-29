package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.UserApp;

public interface UserService {

	void save(UserApp userapp);
	List<UserApp>listAll();
	UserApp get(Long id);
	void delete(Long id); 
	public UserApp UpdateUser(UserApp userApp); 
	 public void AffecterCommentaireAUser(Long idCommentaire , Long idUser); 
	 public void AffecterPublicationAUser (Long idPublication , Long idUser); 
	 public void AffecterLikeAUser (Long idLike , Long idUser);
	 public void AffecterDislikeAUser (Long iddisLike , Long idUser);
	//void ajouterEtAffecterPublicationAUser(Publicationn publicationn , List<Long> idUser) ;
	
	
	
	

}
