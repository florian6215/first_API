package com.basespringboot.controller;

import com.basespringboot.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// Exposes authentication endpoints under /auth
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    // Payload expected for user login
    public record LoginRequest(String username, String password) {}
    // Authenticates credentials and returns a signed JWT token
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest req) {
        // Validate username and password against Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username(), req.password())
        );
        // Generate JWT for the authenticated user
        String token = jwtService.generateToken(req.username());
        return Map.of("token", token);
    }
}