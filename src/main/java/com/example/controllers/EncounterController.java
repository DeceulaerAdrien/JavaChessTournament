package com.example.controllers;

import com.example.services.EncounterService;

public class EncounterController {
    private final EncounterService encounterService;

    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }
}
