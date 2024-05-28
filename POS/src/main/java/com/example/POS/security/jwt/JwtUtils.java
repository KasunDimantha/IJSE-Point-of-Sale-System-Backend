package com.example.POS.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtUtils {
    

    @Value("${app.secret}")
    private String secret;

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    
    public String generateJwtToken(Authentication authentication) {

        UserDetails UserDetails = (UserDetails) authentication.getPrincipal();
        // generate jwt token for the userdetails
        return Jwts.builder()
                .setSubject(UserDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 1000 * 60 * 60 * 24))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

    }
}
