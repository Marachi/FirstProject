package knight;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 */
public class NoKnightException extends Exception {
    public NoKnightException() {
    }
    public NoKnightException(String message) {
        super(message);
    }
}
