package mvc;

import knight.Ammunition;
import knight.Knight;
import knight.NoAmmunitionException;
import knight.NoKnightException;

import java.util.*;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 * Controller
 */
public class Controller {

    //model & view
    private Model model;
    private View view;
    private double priceBottom; //it's default bottom price of any ammunition part (0)

    /**
     * Constructor initializes model and view
     * @param model is model
     * @param view is view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    /**
     * This method creates a Knight,
     * equip him,
     * sorts his ammunition by weight
     * and find ammunition in certain price range
     */
    void processUser(){
        //create a knight
        model.setKnight(new Knight(View.FAMOUS_KNIGHT));

        //equip a knight
        try {
            model.equipKnight(giveAmmo());
        }catch (NoKnightException e){
            e.printStackTrace();
        }

        //sort knight's ammunition by weight
        try {
            model.sortAmmunition();
        } catch (NoKnightException | NoAmmunitionException e) {
            e.printStackTrace();
        }


        //view ammunition in certain price range
        try {
            view.printCollection(model.ammunitionForPrice(inputIntValueWithScanner(new Scanner(System.in)),
                                                            inputIntValueWithScanner(new Scanner(System.in))));
        } catch (NoKnightException | NoAmmunitionException e) {
            e.printStackTrace();
        }
    }


    /**
     *This method create ammunition and puts it in list
     * @return list of ammunition
     */
    public  List<Ammunition> giveAmmo(){

        //create armory
        Map<Ammunition.Type, Ammunition> armory = new HashMap<>();

        //create ammunition elements
        Ammunition helm = new Ammunition(3.1, 300, Ammunition.Type.HELM );
        Ammunition shoulders = new Ammunition(4.1, 500, Ammunition.Type.SHOULDERS );
        Ammunition chest = new Ammunition(7.5, 500, Ammunition.Type.CHEST );
        Ammunition bracers = new Ammunition(1.2, 190, Ammunition.Type.BRACERS );
        Ammunition gloves = new Ammunition(0.7, 90, Ammunition.Type.GLOVES );
        Ammunition pants = new Ammunition(6.1, 230, Ammunition.Type.PANTS );
        Ammunition boots = new Ammunition(2.0, 200, Ammunition.Type.BOOTS );
        Ammunition sword = new Ammunition(5.0, 1200, Ammunition.Type.SWORD);

        //put it in list
        putAmmunition(armory,helm);
        putAmmunition(armory,shoulders);
        putAmmunition(armory,chest);
        putAmmunition(armory, bracers);
        putAmmunition(armory, gloves);
        putAmmunition(armory, pants);
        putAmmunition(armory, boots);
        putAmmunition(armory, sword);

        return  new ArrayList<>(armory.values());
    }

    /**
     * This method guarantees the content of the map is unique
     * for the type of elements of ammunition (by key uniqueness)
     * @param map contains only unique ammunition
     * @param ammunition is putted in map
     */
    private void putAmmunition(Map<Ammunition.Type, Ammunition> map, Ammunition ammunition){
        map.put(ammunition.getType(),ammunition);
    }


    /**
     * This method returns a valid range values
     * @param sc is Scanner
     * @return valid range border
     */
    private double inputIntValueWithScanner(Scanner sc) {

        if(priceBottom==0) {                    //bottom border
            view.printMsg(View.INPUT_DATA);
            view.printMsg(View.INPUT_FROM);
        }else {                                 //top border
            view.printMsg(View.INPUT_TO);
        }

        /*there input data is checked for valid type (expected is double)*/
        while (!sc.hasNextDouble()) {
            view.printMsg(View.WRONG_INPUT_DOUBLE_DATA);
            view.printMsg(View.INPUT_DATA);
            if(priceBottom==0){                 //bottom border
                view.printMsgL(View.INPUT_FROM);
            }else {                             //top border
                view.printMsgL(View.INPUT_TO);
            }
            sc.next();
        }

        //save data in temporary variable a
        double a = sc.nextDouble();

        /*setting bottom price value*/
        if (priceBottom==0){
            /*valid input*/
            if (a >= 0) {
                return  priceBottom=a; //set new bottom value and return it
            }/*invalid input*/else {
                view.printMsg(View.NOT_MINUS);
                return  inputIntValueWithScanner(sc);       //recursive method invocation
            }
        } /*setting top price value*/ else {
            /*valid input*/
            if (a>=priceBottom){
                priceBottom=0;      //clear bottom value
                return a;           //return valid data
            } /*invalid input*/ else {
                view.printMsgAndDouble(View.WRONG_TO,priceBottom);
                return inputIntValueWithScanner(sc);        //recursive method invocation
            }
        }

    }


}
