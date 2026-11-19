package com.basespringboot.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

// Service handling JWT token creation and parsing
@Service
public class JwtService {

    // Signing secret key material and 1-hour token lifetime
    private static final String SECRET = "cleSecreteRocketLeagueSprint2TresLongue2026!";
    private static final long EXPIRATION_MS = 3600_000; // 1 heure
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    // Build and sign a JWT containing the username as subject
    public String generateToken(String username) {
        Date now = new Date();
        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + EXPIRATION_MS))
                .signWith(key)
                .compact();
    }

    // Verify signature and extract the subject (username) from the token
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}