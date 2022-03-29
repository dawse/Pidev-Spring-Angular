package tn.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Soutretance;


@Repository
public interface SoutretanceDAO extends JpaRepository<Soutretance,Integer> {

	
}
