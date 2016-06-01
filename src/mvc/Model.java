package mvc;

import knight.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 */
class Model {

    private Knight knight;   //A knight

    /**
     * This method equips a knight
     * @param ammunition is list of knight ammunition
     */
    void equipKnight(List<Ammunition> ammunition) {
        if (knight!=null) {
            getKnight().setAmmunition(ammunition);
        }
    }

    /**
     * It's facade-method for knight's ammunition sorting
     */
    void sortAmmunition(){
        if (knight!=null) {
            Collections.sort(knight.getAmmunition());
        }
    }

    /**
     * This method find elements of ammunition with price in certain range
     * @param from is bottom price
     * @param to is top price
     * @return list of elements with price in range
     */

    /**
     * This method find elements of ammunition with price in certain range
     * @param from is bottom price
     * @param to is top price
     * @return list of elements with price in range
     * @throws NoKnightException if knight wasn't set
     */
    List<Ammunition> ammunitionForPrice(double from, double to) throws NoKnightException{
        if (knight!=null){
            return getKnight().getAmmunition().stream().
                    filter(ammunition -> ammunition.getPrice() >= from && ammunition.getPrice() <= to)
                    .collect(Collectors.toList());
        }

        throw new  NoKnightException("Set knight first!");
    }

    //setters & getters
    Knight getKnight() {
        return knight;
    }

    void setKnight(Knight knight) {
        this.knight = knight;
    }




}

