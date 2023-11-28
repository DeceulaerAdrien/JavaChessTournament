package com.example.exceptions.tournament;

public class MaxNumberOfPlayerException extends TournamentException{
    public MaxNumberOfPlayerException(){
        super("Le nombre maximum de joueuers a été atteind");
    }
    public MaxNumberOfPlayerException(String message) {
        super(message);
    }
}
