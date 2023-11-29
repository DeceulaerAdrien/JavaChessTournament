package com.example.services;

import com.example.models.entities.Encounter;
import com.example.models.entities.Tournament;

import java.util.Set;

public interface EncounterService {

    Encounter modificationResultat(Long encounterId,Encounter encounter);

    Set<Encounter> generated(Long tournamentId);

    Encounter createdEncounter(Tournament tournament);
}
