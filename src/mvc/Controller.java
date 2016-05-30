package mvc;

import knight.Ammunition;
import knight.Knight;

import java.util.*;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    void processUser(){

        model.setKnight(new Knight("Lancelot"));
        model.getKnight().setAmmunition(giveAmmo());
        view.printCollection( model.getKnight().getAmmunition());
        System.out.println(model.getKnight());


    }



    Collection<Ammunition> giveAmmo(){

        //create map
        Map<Ammunition.Type, Ammunition> armor = new TreeMap<>();

        //put in map armor
        Ammunition helm = new Ammunition(3.1, 300, Ammunition.Type.HELM );
        Ammunition shoulders = new Ammunition(4.1, 500, Ammunition.Type.SHOULDERS );
        Ammunition chest = new Ammunition(7.5, 500, Ammunition.Type.CHEST );
        Ammunition bracers = new Ammunition(1.2, 190, Ammunition.Type.BRACERS );
        Ammunition gloves = new Ammunition(0.7, 90, Ammunition.Type.GLOVES );
        Ammunition pants = new Ammunition(6.1, 230, Ammunition.Type.PANTS );
        Ammunition boots = new Ammunition(2.0, 200, Ammunition.Type.BOOTS );
        Ammunition sword = new Ammunition(5.0, 1200, Ammunition.Type.SWORD);

        armor.put(helm.getType(), helm);
        armor.put(shoulders.getType(), shoulders);
        armor.put(chest.getType(), chest);
        armor.put(bracers.getType(), bracers);
        armor.put(gloves.getType(), gloves);
        armor.put(pants.getType(), pants);
        armor.put(boots.getType(), boots);
        armor.put(sword.getType(), sword);

        return armor.values();
    }



}
