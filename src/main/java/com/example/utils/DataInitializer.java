package com.example.utils;

import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
import com.example.models.entities.enums.TournamentCategorieEnum;
import com.example.models.entities.enums.TournamentStatutEnum;
import com.example.models.entities.enums.security.RoleTypeEnum;
import com.example.repositories.TournamentRepository;
import com.example.repositories.security.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final MemberRepository memberRepository;
    private final TournamentRepository tournamentRepository;
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

        Member seb = new Member();
        seb.setUsername("Seb");
        seb.setRole(RoleTypeEnum.PLAYER);
        seb.setPassword(bCryptUtils.hash("Test1234="));
        seb.setEmail("seb@test.be");
        seb.setBirthDate(LocalDate.of(1991, 8, 19));
        memberRepository.save(seb);

        Tournament tournament = new Tournament();
        tournament.setName("Test");
        tournament.setRound(0);
        tournament.setLocation("qqpart");
        tournament.setWomenOnly(false);
        tournament.setMinPlayer(2);
        tournament.setMaxPlayer(32);
        tournament.setStatut(TournamentStatutEnum.EN_ATTENTE_DE_JOUEUR);
        tournament.setMinElo(0);
        tournament.setMaxElo(3000);
        tournament.addMember(seb);
        tournament.setCategorie(Set.of(TournamentCategorieEnum.JUNIOR,TournamentCategorieEnum.SENIOR,TournamentCategorieEnum.VETERAN));
        tournamentRepository.save(tournament);

//
        List<Member> members = new ArrayList<>();
        members.add(admin);
        Member test = new Member();
        members.add(test);
        members.forEach(System.out::println);
    }
}