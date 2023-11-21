package com.example.models.entities;

import com.example.models.entities.enums.TournamentCategoriesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Tournament extends BaseEntity<Long> {

    @Column(name = "Tournament_name")
    private String name;

    @Column(name = "Tournament_location", nullable = true)
    private String location;

    @Column(name = "Tournament_categorie")
    @Enumerated(EnumType.STRING)
    private TournamentCategoriesEnum categorie;

    @Column(name = "Tournament_statut")
    private String statut;

    @Column(name = "Tournament_min_player")
    @Range(min = 2, max = 32)
    private int minPlayer;

    @Range(min = 2, max = 32)
    @Column(name = "Tournament_max_player")
    private int maxPlayer;

    @Range(min = 0, max = 3000)
    @Column(name = "Tournament_min_elo", nullable = true)
    private int minElo;

    @Column(name = "Tournament_max_elo", nullable = true)
    private int maxElo;

    @Column(name = "Tournament_round")
    private int round;

    @Column(name = "Tournament_women_only")
    private boolean womenOnly;

    @Column(name = "Tournament_end_inscription_date")
    private LocalDate endInscritpionDate;

    @Column(name = "Tournament_creation_date")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "Tournament_update_date")
    @LastModifiedDate
    private LocalDate updateAt;
}
