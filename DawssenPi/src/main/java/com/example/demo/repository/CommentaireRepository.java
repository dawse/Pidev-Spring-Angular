package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{
    @Query("SELECT count(*) FROM Commentaire")
    public int countcm() ;
}
