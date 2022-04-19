package be.technifutur.restaurant.exceptions;

public class UsernameAlreadyExistException extends RuntimeException{

    private final Class<?> clazz;

    public UsernameAlreadyExistException(Class<?> clazz) {
        super("Le compte n'a pas pu être créé car le pseudo est déjà utilisé");
        this.clazz = clazz;
    }
}
