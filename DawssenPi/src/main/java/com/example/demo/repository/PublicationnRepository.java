package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Publicationn;

@Repository
public interface PublicationnRepository extends JpaRepository<Publicationn, Long> {
	public List<Publicationn>findByDomaine(String domaine);
	   @Query("SELECT count(*) FROM Publicationn")
	    public int countpub() ; 

}
