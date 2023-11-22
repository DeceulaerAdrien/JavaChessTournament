package com.example.exceptions.tournament;

public abstract class TournamentException extends RuntimeException {
    public TournamentException(String message) {
        super(message);
    }
}
