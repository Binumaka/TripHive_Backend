package com.example.travel.controller;

import com.example.travel.DTO.BookingDTO;
import com.example.travel.Service.BookingService;
import com.example.travel.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService BookingService;

    @GetMapping("/data")
    public String getData() {
        return "data retrieved";
    }

    @PostMapping("/booking")
    public String createData(@RequestBody BookingDTO BookingDTO) {
        BookingService.save(BookingDTO);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<Book> getAllData() {
        return BookingService.getAll();
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        try {
            Integer BookingId = Integer.parseInt(id);
            Optional<Book> result = BookingService.getById(BookingId);

            if (result.isPresent()) {
                return ResponseEntity.ok(result.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        BookingService.deleteById(id);
    }






}