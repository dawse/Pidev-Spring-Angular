package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Domaineentity;

@Repository
public interface DomaineRepository extends CrudRepository<Domaineentity, Long>{

}
