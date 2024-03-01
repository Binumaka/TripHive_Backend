package com.example.travel.Service.impl;

import com.example.travel.DTO.BookingDTO;
import com.example.travel.Service.BookingService;
import com.example.travel.entity.Book;
import com.example.travel.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository BookingRepository;

    @Override
    public String save(BookingDTO BookingDTO) {
        Book Book = new Book();

        if (BookingDTO.getId() != null) {
            Book = BookingRepository.findById(BookingDTO.getId()).orElseThrow(() -> new NullPointerException("Data not found"));
        }

        Book.setEmail(BookingDTO.getEmail());
        Book.setUsername(BookingDTO.getUsername());
        Book.setAddress(BookingDTO.getAddress());
        Book.setDestinations(BookingDTO.getDestinations());
        Book.setPhoneNumber(BookingDTO.getPhoneNumber());
        Book.setBudgetAmount(BookingDTO.getBudgetAmount());


        BookingRepository.save(Book);

        return "created";
    }

    @Override
    public List<Book> getAll() {
        return BookingRepository.findAll();
    }

    @Override
    public Optional<Book> getById(Integer id) {
        return BookingRepository.findById(id);
    }
    @Override
    public void deleteById(Integer id) {
        BookingRepository.deleteById(id);
    }




}
