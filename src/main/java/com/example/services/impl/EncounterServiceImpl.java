package com.example.services.impl;

import com.example.models.entities.Encounter;
import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
import com.example.models.entities.enums.EncounterResultEnum;
import com.example.repositories.EncounterRepository;
import com.example.repositories.TournamentRepository;
import com.example.services.EncounterService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EncounterServiceImpl implements EncounterService {

    private final EncounterRepository encounterRepository;
    private final TournamentRepository tournamentRepository;

    public EncounterServiceImpl(EncounterRepository encounterRepository, TournamentRepository tournamentRepository) {
        this.encounterRepository = encounterRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Encounter modificationResultat(Long encounterId, Encounter encounter) {
        Encounter changeEncounter = encounterRepository.findById(encounterId).orElseThrow();
        int tournament = encounter.getTournament().getRound();
        if (encounter.getNumber_round() != tournament)
            throw new RuntimeException();
        changeEncounter.setResultEnum(encounter.getResultEnum());
        return this.encounterRepository.save(changeEncounter);
    }

    @Override
    public Set<Encounter> generated(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Set<Encounter> encounterSet = new HashSet<>();
        List<Member> players = tournament.getMemberSet().stream().toList();
        if(players.size() % 2 != 0){
            players.add(new Member());
        }
        int nbPlayer = players.size();
        for (int round = 1; round < nbPlayer * 2;round++){
            for (int i = 0;i <= players.size() / 2;i++){
                if(players.get(i) == null || players.get(nbPlayer - 1 - i) == null){
                    continue;
                }
                Encounter encounter = new Encounter();
                encounter.setJoueurBlanc(round % 2 != 0 ? players.get(i) : players.get(nbPlayer - 1 - i));
                encounter.setJoueurNoir(round % 2 == 0 ? players.get(i) : players.get(nbPlayer - 1 - i));
                encounter.setNumber_round(round);
                encounter.setResultEnum(EncounterResultEnum.NOT_PLAYED);
                encounter.setNumber_encounter(nbPlayer / 2 * nbPlayer * 2 - 1);
                encounterRepository.save(encounter);
                encounterSet.add(encounter);
            }
            players.add(1,players.getLast());
            players.removeLast();
        }
        return encounterSet;
    }

    @Override
    public Encounter createdEncounter(Tournament tournament) {
//        Encounter encounter = new Encounter();
//        encounter.setJoueurBlanc();
        return null;
    }
}
