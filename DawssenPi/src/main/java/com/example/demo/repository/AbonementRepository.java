package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Abonnement;

@Repository
public interface AbonementRepository extends JpaRepository<Abonnement,Long> {
	   @Query("SELECT count(*) FROM Abonnement")
	    public int countabn() ;

}
