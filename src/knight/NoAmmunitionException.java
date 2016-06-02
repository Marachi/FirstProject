package knight;

/**
 * Created by Славик on 01.06.2016.
 * This exception is called in cause no knight when referring to his ammunition
 */
public class NoAmmunitionException extends Exception {
    public NoAmmunitionException() {
    }
    public NoAmmunitionException(String s) {
        super(s);
    }
}
