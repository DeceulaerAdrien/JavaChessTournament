package com.example.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tournament_id")
    private long id;

    @Column(name = "Tournament_name")
    private String name;

    @Column(name = "Tournament_location")
    private String location;

    @Column(name = "Tournament_categorie")
    private String categorie;

    @Column(name = "Tournament_statut")
    private String statut;

    @Column(name = "Tournament_min_player")
    private int minPlayer;

    @Column(name = "Tournament_max_player")
    private int maxPlayer;

    @Column(name = "Tournament_min_elo")
    private int minElo;

    @Column(name = "Tournament_max_elo")
    private int maxElo;

    @Column(name = "Tournament_round")
    private int round;

    @Column(name = "Tournament_women_only")
    private boolean womenOnly;

    @Column(name = "Tournament_end_inscription_date")
    private LocalDate endInscritpionDate;

    @Column(name = "Tournament_update_date")
    @CreatedDate
    private LocalDate createAt;

    @Column(name = "Tournament_creation_date")
    @LastModifiedDate
    private LocalDate updatedAt;
}
