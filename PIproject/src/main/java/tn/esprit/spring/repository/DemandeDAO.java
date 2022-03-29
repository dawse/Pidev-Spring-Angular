package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Demande;
import tn.esprit.spring.entity.Soutretance;

@Repository
public interface DemandeDAO extends JpaRepository<Demande,Integer> {

	public long countBySoutretance(Soutretance soutretance);
	
}
