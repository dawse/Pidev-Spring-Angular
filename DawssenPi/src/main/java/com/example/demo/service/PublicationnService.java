package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Publicationn;


public interface PublicationnService {
	void save(Publicationn publicationn);
	List<Publicationn> listAll();
	Publicationn get(Long id);
	void delete(Long id);
	public Publicationn UpdatePublicationn (Publicationn publicationn); 
	List<Publicationn> getPublicationnByDomaine(String domaine);
	public void AffecterCommentaireAPublication (Long idCommentaire , Long idPublication) ;
	public void AffecterPartageAPublication (Long idPartage , Long idPublication ) ; 
	public void AffecterLikeAPublication (Long idLike , Long idPublication );
	public void AffecterDislikeAPublication (Long iddisLike , Long idPublication );
	public int getNumberpub ();
	/////////////


}
