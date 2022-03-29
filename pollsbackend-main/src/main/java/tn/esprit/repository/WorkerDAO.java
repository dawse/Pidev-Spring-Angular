package tn.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Worker;


@Repository
public interface WorkerDAO extends JpaRepository<Worker,Integer> {

}
