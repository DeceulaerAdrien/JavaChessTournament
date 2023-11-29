package com.example.services.impl;

import com.example.models.entities.Encounter;
import com.example.repositories.EncounterRepository;
import com.example.services.EncounterService;
import org.springframework.stereotype.Service;



@Service
public class EncounterServiceImpl implements EncounterService {

    private final EncounterRepository encounterRepository;

    public EncounterServiceImpl(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
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
    public Encounter generated(Encounter encounter) {
        return this.encounterRepository.save(encounter);
    }
}
