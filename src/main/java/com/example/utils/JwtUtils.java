package com.example.utils;

import com.example.config.JWTConfig;
import com.example.models.entities.Member;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;

import java.util.Date;

@Component
public class JwtUtils {

    private final JWTConfig config;

    private final  JwtBuilder builder;

    private final JwtParser parser;


    public JwtUtils(JWTConfig config, JwtBuilder builder, JwtParser parser) {
        this.config = config;
        this.builder = builder;
        this.parser = parser;
    }

//    public  String generateToken(Member member){
//        return builder
//                .claim("id",member.getId())
//                .claim("Member_Pseudonyme", member.get)
//                .claim("role",member.getRole())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + config.expireAt *1000L))
//                .compact();
    //}
}
