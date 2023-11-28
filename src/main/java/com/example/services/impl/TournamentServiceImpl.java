package com.example.services.impl;

import com.example.exceptions.tournament.AlreadyStartTournamentException;
import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
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
        return tournamentRepository.findTenNotOver();      }

    @Override
    public List<Tournament> getDetails(long id) {
        return null;
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

        tournament.addMember(member);

        memberRepository.save(member);
        tournamentRepository.save(tournament);


    }

    @Override
    public void desinscription(Long memberId , Long tournamentId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();

        member.removeTournament(tournament);

        memberRepository.save(member);
        tournamentRepository.save(tournament);

    }
}
