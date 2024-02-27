package com.example.travel.repository;

import com.example.travel.entity.travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface travelrepository extends JpaRepository <travel, Integer> {
    List<travel> findBySection(String section);
    List<travel> findByCategory(String category);
    List<travel> findByDestinationnameAndCategory(String destinationname, String category);

}