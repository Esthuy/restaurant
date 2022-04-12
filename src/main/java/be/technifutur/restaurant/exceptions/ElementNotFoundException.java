package be.technifutur.restaurant.exceptions;

public class ElementNotFoundException extends RuntimeException{

    private final Object id;
    private final Class<?> clazz;

    public ElementNotFoundException(Object id, Class<?> clazz) {
        super("lélément d'id {" + id + "} n'a pas pu être trouvé");
        this.id = id;
        this.clazz = clazz;
    }



}
