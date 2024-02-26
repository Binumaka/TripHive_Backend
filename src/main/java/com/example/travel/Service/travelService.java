package com.example.travel.Service;

import com.example.travel.DTO.traveldto;
import com.example.travel.entity.travel;

import java.util.List;
import java.util.Optional;

public interface travelService {
    String save(traveldto plantdto);

    List<travel> getAll();
    Optional<travel> getById(Integer id);
    void deleteById(Integer id);
    String update(Integer id, traveldto plantdto);
}