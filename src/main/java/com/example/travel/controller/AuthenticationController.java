package com.example.travel.controller;

import com.example.travel.DTO.AuthenticationRequest;
import com.example.travel.DTO.AuthenticationResponse;
import com.example.travel.Service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticateService authenticateService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticateRequest) {

        return authenticateService.authenticate(authenticateRequest);
    }

}