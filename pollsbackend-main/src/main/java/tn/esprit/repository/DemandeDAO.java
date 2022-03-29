package tn.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Demande;
import tn.esprit.entities.Soutretance;


@Repository
public interface DemandeDAO extends JpaRepository<Demande,Integer> {

	public long countBySoutretance(Soutretance soutretance);
	
}
