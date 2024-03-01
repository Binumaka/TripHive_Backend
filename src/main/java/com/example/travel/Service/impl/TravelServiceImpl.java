package com.example.travel.Service.impl;

import com.example.travel.DTO.TravelDto;
import com.example.travel.Service.travelService;
import com.example.travel.entity.travel;
import com.example.travel.repository.travelrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements travelService {

    private final travelrepository travelrepository;

    @Override
    public String save(TravelDto traveldto) {
        travel travel = new travel();

        if (traveldto.getId() != null) {
            travel = travelrepository.findById(traveldto.getId()).orElseThrow(() -> new NullPointerException("Data not found"));
        }

        travel.setDestinationname(traveldto.getDestinationname());
        travel.setDescription(traveldto.getDescription());
        travel.setCategory(traveldto.getCategory());
        travel.setSection(traveldto.getSection());
        travel.setImageurl(traveldto.getImageurl());

        travelrepository.save(travel);

        return "created";
    }

    @Override
    public List<travel> getAll() {
        return travelrepository.findAll();
    }

    @Override
    public Optional<travel> getById(Integer id) {
        return travelrepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        travelrepository.deleteById(id);
    }

    public String update(Integer id, TravelDto TravelDto) {
        Optional<travel> optionalDestination = travelrepository.findById(id);

        if (optionalDestination.isPresent()) {
            travel existingDestination = optionalDestination.get();

            existingDestination.setDestinationname(TravelDto.getDestinationname());
            existingDestination.setDescription(TravelDto.getDescription());
            existingDestination.setCategory(TravelDto.getCategory());
            existingDestination.setSection(TravelDto.getSection());
            existingDestination.setImageurl(TravelDto.getImageurl());

            travelrepository.save(existingDestination);

            return "updated";
        } else {
            return "Destination not found with id: " + id;
        }

    }
    public List<travel> getDestinationsBySection(String section) {
        return travelrepository.findBySection(section);
    }

    public List<travel> getDestinationsByCategory(String category) {
        return travelrepository.findByCategory(category);
    }
    public List<travel> searchDestinations(String destinationname, String category) {
        return travelrepository.findByDestinationnameAndCategory(destinationname, category);
    }
}