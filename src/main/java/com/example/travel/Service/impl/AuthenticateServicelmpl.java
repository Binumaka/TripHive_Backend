package com.example.travel.Service.impl;

import com.example.travel.DTO.AuthenticationRequest;
import com.example.travel.DTO.AuthenticationResponse;
import com.example.travel.Security.JwtService;
import com.example.travel.Service.AuthenticateService;
import com.example.travel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServicelmpl implements AuthenticateService {

    private final UserRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(), authenticateRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) userRepo.getUserByUsername(authenticateRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}