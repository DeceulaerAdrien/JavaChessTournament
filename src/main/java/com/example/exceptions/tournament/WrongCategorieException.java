package com.example.exceptions.tournament;

public class WrongCategorieException extends TournamentException{
    public WrongCategorieException(){
        super("Vous ne faite pas parti de la bonne catégorie.");
    }
    public WrongCategorieException(String message) {
        super(message);
    }
}
