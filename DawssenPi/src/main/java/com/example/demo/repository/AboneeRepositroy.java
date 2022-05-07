package com.example.demo.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Abonee;


@Repository
public interface AboneeRepositroy extends JpaRepository<Abonee, Long>  {
//public List<Abonee>findByDomaine_interet(String domaine_interet);
	   @Query("SELECT count(*) FROM Abonee")
	    public int countab() ; 
	
	
	
}
