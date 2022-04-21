package be.technifutur.restaurant.exceptions;

public class MailAlreadyExistException extends RuntimeException{

    private final Class<?> clazz;

    public MailAlreadyExistException(Class<?> clazz) {
        super("Le compte n'a pas pu être créé car ce mail est déjà utilisé");
        this.clazz = clazz;
    }
}
