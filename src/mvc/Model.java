package mvc;

import knight.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Model {

    private Knight knight;

    void sortAmmunition(){
        Collections.sort(getKnight().getAmmunition());
    }

    List<Ammunition> ammunitionForPrice(double from, double to){

        List<Ammunition> arrayList = new ArrayList<>();

        for (Ammunition ammunition : getKnight().getAmmunition()) {
            if (ammunition.getPrice() >= from && ammunition.getPrice() <= to) {
                arrayList.add(ammunition);
            }
        }
        return arrayList;
    }

    Knight getKnight() {
        return knight;
    }

    void setKnight(Knight knight) {
        this.knight = knight;
    }

    void equipKnight(List<Ammunition> ammunitions) {
        getKnight().setAmmunition(ammunitions);
    }


}

