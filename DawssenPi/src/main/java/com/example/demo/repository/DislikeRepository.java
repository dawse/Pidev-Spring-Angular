package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Dislike;
@Repository
public interface DislikeRepository extends JpaRepository<Dislike, Long> {
    @Query("SELECT count(*) FROM Dislike")
    public int countds() ;
}
