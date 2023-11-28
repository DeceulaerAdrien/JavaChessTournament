package com.example.exceptions.tournament;

public class EndOfInscriptionException extends TournamentException{
    public EndOfInscriptionException() {
        super("La date d'inscription pour le tournois est dépassée");
    }
    public EndOfInscriptionException(String message) {
        super(message);
    }
}
