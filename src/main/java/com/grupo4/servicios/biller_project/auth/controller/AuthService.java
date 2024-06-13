package com.grupo4.servicios.biller_project.auth.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.grupo4.servicios.biller_project.entities.Role;
import com.grupo4.servicios.biller_project.entities.User;
import com.grupo4.servicios.biller_project.auth.jwt.JwtService;
import com.grupo4.servicios.biller_project.repositories.RoleRepository;
import com.grupo4.servicios.biller_project.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    //
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {

        Role userRole = roleRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = User.builder()
        .role(userRole) 
        .username(request.getUsername())
        //.password(request.getPassword())
        .password(passwordEncoder.encode( request.getPassword()))
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

    }

}
