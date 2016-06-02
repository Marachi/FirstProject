package mvc;

import knight.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 */
public class Model {

    private Knight knight;   //A knight

    /**
     * This method equips a knight
     * @param ammunition is list of knight ammunition
     */
    public void equipKnight(List<Ammunition> ammunition) throws NoKnightException{
        if (knight!=null) {
            getKnight().setAmmunition(ammunition);
        }else {
            throw new NoKnightException();
        }
    }

    /**
     * It's facade-method for knight's ammunition sorting
     */
    public void sortAmmunition() throws NoKnightException, NoAmmunitionException {
        if (knight!=null) {

            if (knight.getAmmunition()!=null) {
                Collections.sort(knight.getAmmunition());
            }else {
                throw new NoAmmunitionException("Knight without ammunition!");
            }

        }else {
            throw new NoKnightException("Set knight first!");
        }
    }


    /**
     * This method find elements of ammunition with price in certain range
     * @param from is bottom price
     * @param to is top price
     * @return list of elements with price in range
     * @throws NoKnightException if knight wasn't set
     */
    public List<Ammunition> ammunitionForPrice(double from, double to) throws NoKnightException,NoAmmunitionException{
        if (knight!=null){
            if (knight.getAmmunition()!=null) {

                return getKnight().getAmmunition().stream().
                        filter(ammunition -> ammunition.getPrice() >= from && ammunition.getPrice() <= to)
                        .collect(Collectors.toList());
            }else {
                throw new NoAmmunitionException("Knight without ammunition!");
            }

        }

        throw new  NoKnightException("Set knight first!");
    }

    //setters & getters
    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }




}

