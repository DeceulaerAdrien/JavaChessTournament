package com.example.models.entities;

import com.example.models.entities.members.Player;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PlayerTournament extends BaseRelation<PlayerTournament.PlayerTournamentId>{

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @Getter@Setter
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @Getter@Setter
    private Tournament tournament;

    public static class PlayerTournamentId implements Serializable {
        @Getter@Setter
        private long playerId;
        @Getter@Setter
        private long tournamentId;
    }
}
