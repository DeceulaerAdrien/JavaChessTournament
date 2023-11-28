package com.example.utils;

import com.example.models.entities.Member;
import com.example.models.entities.enums.security.RoleTypeEnum;
import com.example.repositories.security.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final BCryptUtils bCryptUtils;

    @Override
    public void run(String... args) throws RuntimeException {
        Member admin = new Member();
        admin.setUsername("Checkmate");
        admin.setRole(RoleTypeEnum.ADMIN);
        admin.setPassword(bCryptUtils.hash("adminPassword"));
        admin.setEmail("misterCheckmat@test.com");
        admin.setBirthDate(LocalDate.of(1997, 8, 19));
        memberRepository.save(admin);
    }
}