package com.example.utils;

import com.example.models.entities.Member;
import com.example.repositories.secu.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

public class DataInitializer implements CommandLineRunner {

    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        String passWord = passwordEncoder.encode("Test123");
        //Member m = new Member("Lulu","mail@com",'m',passWord,"pegu");


    }
}
