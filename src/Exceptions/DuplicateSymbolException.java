package Exceptions;

public class DuplicateSymbolException extends RuntimeException{

    public DuplicateSymbolException(Character character){
        System.out.println(" Models.Symbol " + character + " is repeated twice.");
    }
}
