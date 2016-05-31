package mvc;

import knight.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by potaychuk on 30.05.2016.
 */
class Model {

    private Knight knight;   //A knight

    /**
     * This method equips a knight
     * @param ammunitions is list of knight ammunition
     */
    void equipKnight(List<Ammunition> ammunitions) {
        getKnight().setAmmunition(ammunitions);
    }

    /**
     * It's facade-method for ammunition sorting
     * @param list is collection which will be sorted
     */
    void sortAmmunition(List<Ammunition> list){
        Collections.sort(list);
    }

    /**
     * This method find elements of ammunition with price in certain range
     * @param from is bottom price
     * @param to is top price
     * @return list of elements with price in range
     */
    List<Ammunition> ammunitionForPrice(double from, double to){
        return getKnight().getAmmunition().stream().
                filter(ammunition -> ammunition.getPrice() >= from && ammunition.getPrice() <= to)
                .collect(Collectors.toList());
    }

    //setters & getters
    Knight getKnight() {
        return knight;
    }

    void setKnight(Knight knight) {
        this.knight = knight;
    }




}

