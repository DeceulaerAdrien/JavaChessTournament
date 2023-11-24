package com.example.controllers;


import com.example.models.dtos.tournament.TounamentShortDTO;
import com.example.models.dtos.tournament.TournamentDTO;
import com.example.models.entities.Tournament;
import com.example.models.forms.TournamentForm;
import com.example.services.TournamentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public ResponseEntity<TournamentDTO> create(@RequestBody @Valid TournamentForm tournamentForm) {
        Tournament tournament = tournamentService.create(tournamentForm.toEntity());
        return ResponseEntity.ok(TournamentDTO.fromEntity(tournament));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TournamentDTO> getById(@PathVariable("id")Long id){
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.getbyId(id));
        return ResponseEntity.ok(tournamentDTO);
    }
    @GetMapping("/list")
    public ResponseEntity<List<TounamentShortDTO>> getAll(){
        List<Tournament> tournaments = tournamentService.getAll();
        List<TounamentShortDTO> tounamentShortDTOS = tournaments.stream().map(TounamentShortDTO ::fromEntity).toList();
        return ResponseEntity.ok(tounamentShortDTOS);
    }




    @PutMapping(path = "/{id}")
    public ResponseEntity<TournamentDTO> update(
            @PathVariable("id") Long id,
            @RequestBody TournamentForm tournamentForm
    ){
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.update(id,tournamentForm.toEntity()));
        return ResponseEntity.ok(tournamentDTO);
    }

    @DeleteMapping()
    public ResponseEntity.BodyBuilder delete(
            @PathVariable("id") Long id
    ){
        LocalDate TodayDate = LocalDate.now();

//        if (){
//
//        }
        this.tournamentService.delete(id);
        return ResponseEntity.ok();
    }
}
