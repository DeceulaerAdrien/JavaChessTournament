package com.example.controllers;
import com.example.models.dtos.encounter.EncounterDTO;
import com.example.models.forms.EncounterForm;
import com.example.services.EncounterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encounter")
@CrossOrigin("*")
public class EncounterController {
    private final EncounterService encounterService;

    public EncounterController(EncounterService encounterService) {
        this.encounterService = encounterService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(path = "/modification/{id}")
    public ResponseEntity<EncounterDTO> update(
            @PathVariable("id") Long id,
            @RequestBody EncounterForm encounterForm
    ) {
        EncounterDTO encounterDTO = EncounterDTO.fromEntity(this.encounterService.modificationResultat(id, encounterForm.toEntity()));
        return ResponseEntity.ok(encounterDTO);
    }
}
