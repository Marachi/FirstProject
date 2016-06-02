package knight;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 * This exception is called in cause no knight when referring to him
 */
public class NoKnightException extends Exception {
    public NoKnightException() {
    }
    public NoKnightException(String message) {
        super(message);
    }
}
