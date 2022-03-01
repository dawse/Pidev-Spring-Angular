package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Abonement;

@Repository
public interface AbonementRepository extends JpaRepository<Abonement, Long> {

}
