package com.example.models.entities;

import com.example.models.entities.enums.TournamentCategorieEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
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
    private Long id;

    @Column(name = "Tournament_name")
    private String name;

    @Column(name = "Tournament_location",nullable = true)
    private String location;

    @Column(name = "Tournament_categorie")
    @Enumerated(EnumType.STRING)
    private TournamentCategorieEnum categorie ;

    @Column(name = "Tournament_statut")
    private String statut ;

    @Column(name = "Tournament_min_player")
    @Range(min = 2,max = 32)
    private int minPlayer ;

    @Column(name = "Tournament_max_player")
    @Range(min = 2,max = 32)
    private int maxPlayer ;

    @Column(name = "Tournament_min_elo",nullable = true)
    @Range(min = 0,max = 3000)
    private int minElo ;

    @Column(name = "Tournament_max_elo",nullable = true)
    @Range(min = 0,max = 3000)
    private int maxElo ;

    @Column(name = "Tournament_round")
    private int round ;

    @Column(name = "Tournament_women_only")
    private boolean womenOnly;

    @Column(name = "Tournament_end_inscription_date")
    private LocalDate endInscriptionDate;

    @CreatedDate
    @Column(name = "Tournament_created_date")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "Tournament_update_date")
    private LocalDate updatedAt;




}
