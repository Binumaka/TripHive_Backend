package com.example.travel.repository;

import com.example.travel.entity.travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface travelrepository extends JpaRepository <travel, Integer> {


}