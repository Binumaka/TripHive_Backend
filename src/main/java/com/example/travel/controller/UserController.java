package com.example.travel.controller;

import com.example.travel.DTO.UserDto;
import com.example.travel.Service.UserService;
import com.example.travel.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/data")
    public  String getData(){
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody UserDto userDto){
        userService.save(userDto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<User> getAllData() {
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }

}