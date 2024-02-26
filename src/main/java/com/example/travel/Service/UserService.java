package com.example.travel.Service;

import com.example.travel.DTO.UserDto;
import com.example.travel.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserDto userDto);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);
}