package com.example.utils;

import com.example.models.entities.Member;
import com.example.models.entities.enums.MemberGenderEnum;
import com.example.repositories.security.AuthRepository;
import jakarta.xml.bind.annotation.XmlType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        String password = passwordEncoder.encode("Test123");
        Member m = new Member("Checkmate",
                password,
                "test@mail",
                "ADMIN",
                MemberGenderEnum.MALE, LocalDate.of(1997,8,19),1200,true);
        m.setId(1L);
        authRepository.save(m);
    }
}