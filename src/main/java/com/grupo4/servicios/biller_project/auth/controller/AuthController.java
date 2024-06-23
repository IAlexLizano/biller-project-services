package com.grupo4.servicios.biller_project.auth.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /*
     * @PostMapping(value = "login")
     * public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
     * {
     * return ResponseEntity.ok(authService.login(request));
     * }
     */
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Retorna 401 si las credenciales son
                                                                              // incorrectas
        }
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(value = "logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        // Lógica para invalidar el token, si es necesario
        return ResponseEntity.ok().build();
    }
}
