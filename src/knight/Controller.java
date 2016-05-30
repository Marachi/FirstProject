package knight;

import com.sun.javafx.sg.prism.NGShape;

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

        model.setKnight(new Knight("Aivengo"));
        model.getKnight().setAmmo(new TreeSet<>(giveAmmo().values()));
        view.printCollection( model.getKnight().getAmmo());
        System.out.println(model.getKnight());


    }



    Map<Knight.Slots, Ammo> giveAmmo(){

        //create map
        Map<Knight.Slots, Ammo> armor = new TreeMap<>();

        //put in map armor
        armor.put(Knight.Slots.HEAD, new Ammo(3.1, 300, Ammo.ArmorType.HELM ));
        armor.put(Knight.Slots.SHOULDERS, new Ammo(4.1, 500, Ammo.ArmorType.SHOULDERS ));
        armor.put(Knight.Slots.BODY,new Ammo(7.5, 500, Ammo.ArmorType.CHEST ));
        armor.put(Knight.Slots.HANDS,new Ammo(1.2, 190, Ammo.ArmorType.BRACERS ));
        armor.put(Knight.Slots.ARMS,new Ammo(0.7, 90, Ammo.ArmorType.GLOVES ));
        armor.put(Knight.Slots.LEGS,new Ammo(6.1, 230, Ammo.ArmorType.PANTS ));
        armor.put(Knight.Slots.FEETS,new Ammo(2.0, 200, Ammo.ArmorType.BOOTS ));

        return armor;
    }



}
