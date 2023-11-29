package com.example.services.impl;

import com.example.models.entities.Encounter;
import com.example.models.entities.Tournament;
import com.example.repositories.EncounterRepository;
import com.example.services.EncounterService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EncounterServiceImpl implements EncounterService {

    private final EncounterRepository encounterRepository;

    public EncounterServiceImpl(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    @Override
    public Encounter modificationResultat(Long encounterId, Encounter encounter) {
        Encounter changeEncounter = encounterRepository.findById(encounterId).orElseThrow();
        changeEncounter.setResultEnum(encounter.getResultEnum());
        return this.encounterRepository.save(changeEncounter);
    }

    @Override
    public Encounter create(Encounter encounter) {
        return this.encounterRepository.save(encounter);
    }
}
//    @Override
//    public Tournament update(Long id, Tournament tournament) {
//        Tournament changeTournament = tournamentRepository.findById(id).orElseThrow();
//        changeTournament.setName(tournament.getName());
//        changeTournament.setLocation(tournament.getLocation());
//        changeTournament.setCategorie(tournament.getCategorie());
//        changeTournament.setStatut(tournament.getStatut());
//        changeTournament.setMaxElo(tournament.getMaxElo());
//        changeTournament.setMinElo(tournament.getMinElo());
//        changeTournament.setMaxPlayer(tournament.getMaxPlayer());
//        changeTournament.setMinPlayer(tournament.getMinPlayer());
//        changeTournament.setWomenOnly(tournament.isWomenOnly());
//        changeTournament.setRound(tournament.getRound());
//        changeTournament.setEndInscritpionDate(tournament.getEndInscritpionDate());
//        changeTournament.setUpdateAt(LocalDate.now());
//        return this.tournamentRepository.save(changeTournament);
