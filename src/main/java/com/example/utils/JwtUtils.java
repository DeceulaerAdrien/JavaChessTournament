package com.example.utils;

import com.example.config.JWTConfig;
import com.example.models.entities.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;

import java.util.Date;

@Component
public class JwtUtils {

    private final JWTConfig config;

    private final JwtBuilder builder;

    private final JwtParser parser;


    public JwtUtils(JWTConfig config) {
        this.config = config;
        this.builder = Jwts.builder().signWith(config.secretKey);
        this.parser = Jwts.parserBuilder().setSigningKey(config.secretKey).build();
    }

    public String generateToken(Member member) {
        return builder
                .claim("id", member.getId())
                .claim("username", member.getUsername())
                .claim("role", member.getRole())
                .claim("email", member.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (config.expireAt * 1000L)))
                .compact();
    }

    public Claims getClaims(String token) {
        return parser.parseClaimsJws(token).getBody();
    }

    public String getUsername(String token) {
        return getClaims(token).get("username", String.class);
    }
    public Long getId(String token) {
        return getClaims(token).get("id", Long.class);
    }

    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public boolean isValid(String token) {
        Claims claims = getClaims(token);
        Date now = new Date();
        return getRole(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}