package com.example.services.impl;

import com.example.exceptions.member.AlreadyExistMemberException;
import com.example.exceptions.tournament.AlreadyStartTournamentException;
import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
import com.example.models.entities.enums.MemberGenderEnum;
import com.example.models.entities.enums.TournamentCategorieEnum;
import com.example.repositories.TournamentRepository;
import com.example.repositories.security.MemberRepository;
import com.example.services.TournamentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
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
        if(tournament.getEndInscritpionDate().isAfter(LocalDate.now()))
            throw new RuntimeException();
        if (tournament.getMemberSet().contains(member))
            throw new AlreadyExistMemberException();
        if (tournament.getMemberSet().size() == tournament.getMaxPlayer())
            throw new RuntimeException();
        if (member.getBirthDate().until(LocalDate.now()).getYears() > 18 && tournament.getCategorie().contains(TournamentCategorieEnum.JUNIOR))
            throw new RuntimeException();
        if (member.getElo() < tournament.getMinElo() || member.getElo() > tournament.getMaxElo())
            throw new RuntimeException();
        if (tournament.isWomenOnly() && !(member.getGender().equals(MemberGenderEnum.FEMALE)))

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
            throw new AlreadyExistMemberException();

        tournament.removeMember(member);

        memberRepository.save(member);
        tournamentRepository.save(tournament);

    }
}
