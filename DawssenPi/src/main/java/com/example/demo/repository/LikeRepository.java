package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT count(*) FROM Like")
    public int countlk() ;
 

}
