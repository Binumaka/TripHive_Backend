package com.example.travel.Service;


import com.example.travel.DTO.BookingDTO;
import com.example.travel.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    String save(BookingDTO BookingDTO);

    List<Book> getAll();
    Optional<Book> getById(Integer id);
    void deleteById(Integer id);


}