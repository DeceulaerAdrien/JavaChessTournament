package com.example.services.impl;

import com.example.exceptions.tournament.*;
import com.example.models.entities.Encounter;
import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
import com.example.models.entities.enums.MemberGenderEnum;
import com.example.models.entities.enums.TournamentCategorieEnum;
import com.example.repositories.EncounterRepository;
import com.example.repositories.TournamentRepository;
import com.example.repositories.security.MemberRepository;
import com.example.services.EncounterService;
import com.example.services.TournamentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    private final EncounterService encounterService;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, MemberRepository memberRepository, EncounterRepository encounterRepository, EncounterService encounterService) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
        this.encounterService = encounterService;
    }

    @Override
    public Tournament create(Tournament tournament) {
        return this.tournamentRepository.save(tournament);
    }

    @Override
    public void delete(Long id) {
        Tournament tournament = this.getbyId(id);
        if (tournament.getStatut().toString().equals("EN_COURS"))
            throw new AlreadyStartTournamentException();
        this.tournamentRepository.delete(tournament);
    }

    @Override
    public Tournament getbyId(Long id) {
        return this.tournamentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Tournament> getTenNotOVer() {
        return tournamentRepository.findTenNotOver();
    }

    @Override
    public Tournament getDetails(long id) {
        return tournamentRepository.findById(id).orElseThrow();
    }

    @Override
    public Tournament update(Long id, Tournament tournament) {
        Tournament changeTournament = tournamentRepository.findById(id).orElseThrow();
        changeTournament.setName(tournament.getName());
        changeTournament.setLocation(tournament.getLocation());
        changeTournament.setCategorie(tournament.getCategorie());
        changeTournament.setStatut(tournament.getStatut());
        changeTournament.setMaxElo(tournament.getMaxElo());
        changeTournament.setMinElo(tournament.getMinElo());
        changeTournament.setMaxPlayer(tournament.getMaxPlayer());
        changeTournament.setMinPlayer(tournament.getMinPlayer());
        changeTournament.setWomenOnly(tournament.isWomenOnly());
        changeTournament.setRound(tournament.getRound());
        changeTournament.setEndInscritpionDate(tournament.getEndInscritpionDate());
        changeTournament.setUpdateAt(LocalDate.now());
        return this.tournamentRepository.save(changeTournament);

    }

    @Override
    public void inscription(Long memberId, Long tournamentId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        if (tournament.getStatut().toString().equals("EN_COURS"))
            throw new AlreadyStartTournamentException("Vous ne pouvez pas vous inscrire à un tournois qui a déja commencé.");
        if(tournament.getEndInscritpionDate().isBefore(LocalDate.now()))
            throw new EndOfInscriptionException();
        if (tournament.getMemberSet().contains(member))
            throw new AlreadyInTournamentException();
        if (tournament.getMemberSet().size() == tournament.getMaxPlayer())
            throw new MaxNumberOfPlayerException();
        if (member.getBirthDate().until(LocalDate.now()).getYears() < 18 && !(tournament.getCategorie().contains(TournamentCategorieEnum.JUNIOR)))
            throw new WrongCategorieException();
        if (member.getBirthDate().until(LocalDate.now()).getYears() >= 18 && !(tournament.getCategorie().contains(TournamentCategorieEnum.SENIOR)))
            throw new WrongCategorieException();
        if (member.getBirthDate().until(LocalDate.now()).getYears() >= 60 && !(tournament.getCategorie().contains(TournamentCategorieEnum.VETERAN)))
            throw new WrongCategorieException();
        if (member.getElo() < tournament.getMinElo() || member.getElo() > tournament.getMaxElo())
            throw new BadNumberOfEloException();
        if (tournament.isWomenOnly() && !(member.getGender().equals(MemberGenderEnum.FEMALE)))
            throw new WrongGenderException();

        tournament.addMember(member);

        memberRepository.save(member);
        tournamentRepository.save(tournament);


    }


    @Override
    public void desinscription(Long memberId , Long tournamentId) {

        Member member = memberRepository.findById(memberId).orElseThrow();
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();

        if (tournament.getStatut().toString().equals("EN_COURS"))
            throw new AlreadyStartTournamentException("Vous ne pouvez pas quitter un tournois qui a déja débuté.");
        if (!tournament.getMemberSet().contains(member))
            throw new AlreadyInTournamentException("Vous n'êtes pas inscrit à ce tournois.");

        tournament.removeMember(member);

        memberRepository.save(member);
        tournamentRepository.save(tournament);

    }

    @Override
    public void tournamentStart(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
//        if (tournament.getMemberSet().size() < tournament.getMinPlayer())
//            throw new MaxNumberOfPlayerException("Vous n'avez pas assez de participants pour lancer ce tournois.");
//        if(LocalDate.now().isBefore(tournament.getEndInscritpionDate()))
//            throw new EndOfInscriptionException("Le délai d'inscription n'est pas encore fini");
        tournament.setRound(tournament.getRound()+1);

        Set<Encounter> encounters = encounterService.generated(tournamentId);
    }
}
