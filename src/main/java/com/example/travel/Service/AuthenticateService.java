package com.example.travel.Service;


import com.example.travel.DTO.AuthenticationRequest;
import com.example.travel.DTO.AuthenticationResponse;

public interface AuthenticateService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticateRequest);
}