package com.example.models.entities;

import com.example.models.entities.enums.EncounterResultEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class Encounter extends BaseEntity<Long> {


    @ManyToOne
    private Tournament tournament;

    @ManyToOne @Setter @JoinColumn(name = "White_Player_id")
    private Member joueurBlanc;

    @ManyToOne @Setter @JoinColumn(name = "Black_Player_id")
    private Member joueurNoir;

    @Setter
    @Column(name = "Number_Round")
    private int number_round;

    @Enumerated(EnumType.STRING)@Setter
    @Column(name = "Result_Encounter",columnDefinition = "Varchar DEFAULT 'NOT_PLAYED'")
    private EncounterResultEnum resultEnum;

    @Setter
    @Column(name = "Number_Encounter")
    private int number_encounter;

}
