package com.example.models.entities;

import com.example.models.entities.members.Player;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@ToString
@EqualsAndHashCode
public class PlayerTournament extends BaseRelation<PlayerTournament.PlayerTournamentId> {

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @Setter
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("tournamentId")
    @Setter
    private Tournament tournament;

    @Getter
    public static class PlayerTournamentId implements Serializable {
        @Setter
        private long playerId;
        @Setter
        private long tournamentId;
    }
}