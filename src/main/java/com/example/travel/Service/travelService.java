package com.example.travel.Service;

import com.example.travel.DTO.TravelDto;
import com.example.travel.entity.travel;

import java.util.List;
import java.util.Optional;

public interface travelService {
    String save(TravelDto traveldto);

    List<travel> getAll();
    Optional<travel> getById(Integer id);
    void deleteById(Integer id);
    String update(Integer id, TravelDto traveldto);

    List<travel> getDestinationsBySection(String section);
    List<travel> getDestinationsByCategory(String category);
    List<travel> searchDestinations(String plantname, String category);
}