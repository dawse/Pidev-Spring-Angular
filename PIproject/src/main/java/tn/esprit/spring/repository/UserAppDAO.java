package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.UserApp;

@Repository
public interface UserAppDAO extends JpaRepository<UserApp, Long> {

}
