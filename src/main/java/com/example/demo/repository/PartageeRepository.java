package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Partagee;

@Repository
public interface PartageeRepository extends JpaRepository<Partagee, Long> {

}
