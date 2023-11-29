package com.example.services;

import com.example.models.entities.Encounter;

public interface EncounterService {

    Encounter modificationResultat(Long encounterId,Encounter encounter);

    Encounter create(Encounter encounter);
}
