package com.example.travel.controller;

import com.example.travel.DTO.TravelDto;
import com.example.travel.Service.travelService;
import com.example.travel.entity.travel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/destination")
@RequiredArgsConstructor
public class TravelController {

    private final travelService travelService;

    @GetMapping("/data")
    public  String getData(){
        return "data retrieved";
    }

    @PostMapping("/travel")
    public String createData(@RequestBody TravelDto traveldto){
        travelService.save(traveldto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<travel> getAllData() {
        return travelService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<travel> getById(@PathVariable("id") Integer id) {
        return travelService.getById(id);
    }

    @PutMapping("/update/{id}")
    public String updateData(@PathVariable("id") Integer id, @RequestBody TravelDto TravelDto) {
        Optional<travel> existingDestination = travelService.getById(id);

        if (existingDestination.isPresent()) {
            travelService.update(id, TravelDto);
            return "updated data";
        } else {
            return "Destination not found with id: " + id;
        }
    }


    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") Integer id) {
        travelService.deleteById(id);
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<List<travel>> getDestinationsBySection(@PathVariable String section) {
        List<travel> destinations = travelService.getDestinationsBySection(section);
        if (destinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(destinations, HttpStatus.OK);
        }
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<travel>> getDestinationsByCategory(@PathVariable String category) {
        List<travel> destinations = travelService.getDestinationsByCategory(category);
        if (destinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(destinations, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<travel>> searchDestinations(@RequestParam String destinationname, @RequestParam String category) {
        List<travel> destinations = travelService.searchDestinations(destinationname, category);
        if (destinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(destinations, HttpStatus.OK);
        }
    }
}