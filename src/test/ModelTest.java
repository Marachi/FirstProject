package test;


import knight.Ammunition;
import knight.Knight;
import knight.NoAmmunitionException;
import knight.NoKnightException;
import mvc.Controller;
import mvc.Model;
import mvc.View;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 */
public class ModelTest {


    private Model model = new Model();
    private View view = new View();
    private Controller controller = new Controller(model,view);




    /**
     * This method checks the availability of equipment
     */
    @Test
    public void equipKnightTest() throws NoKnightException {
        model.setKnight(new Knight(View.FAMOUS_KNIGHT));//set a Knight
        model.equipKnight(controller.giveAmmo());       // equip him
        Assert.assertTrue(model.getKnight().getAmmunition().equals(controller.giveAmmo()));
    }

    /**
     * This method checks presence of NoKnightException
     */
    @Test(expected = NoKnightException.class)
    public void equipKnightNoKnight() throws NoKnightException {
        //model.setKnight(new Knight(View.FAMOUS_KNIGHT));//set a Knight
        model.equipKnight(controller.giveAmmo());       // equip him
    }



    /**
     * This method checks valid of sorting
     */
    @Test
    public void sortAmmunitionTest() throws NoKnightException, NoAmmunitionException {
        model.setKnight(new Knight(View.FAMOUS_KNIGHT));  //set a Knight
        model.equipKnight(controller.giveAmmo());         // equip him

        List<Ammunition> temp =  model.getKnight().getAmmunition();  //temporary copy of equipment list

        model.sortAmmunition();                           //sorting
        Collections.sort(temp);                           //sorting

        boolean sorted = true;                            // a necessary variable

        for (int i =0; i<temp.size(); i++){
            if (!temp.get(i).equals(model.getKnight().getAmmunition().get(i))){
                sorted=false;
            }
        }
        Assert.assertTrue(sorted);

    }

    /**
     * This method checks presence of NoAmmunitionException
     */
    @Test(expected = NoAmmunitionException.class)
    public void sortAmmunitionNoAmmunition() throws NoKnightException, NoAmmunitionException {
        model.setKnight(new Knight(View.FAMOUS_KNIGHT));  //set a Knight
        //        model.equipKnight(controller.giveAmmo());         // equip him
        model.sortAmmunition();                           //sorting
    }

    /**
     * This method checks presence of NoKnightException
     */
    @Test(expected = NoKnightException.class)
    public void sortAmmunitionNoKnight() throws NoKnightException, NoAmmunitionException {
        //        model.setKnight(new Knight(View.FAMOUS_KNIGHT));  //set a Knight
        //        model.equipKnight(controller.giveAmmo());         // equip him
        model.sortAmmunition();                           //sorting
    }

    /**
     * This method checks price of elements returned by ammunitionForPrice()
     */
    @Test
    public void ammunitionForPriceTest() throws NoKnightException, NoAmmunitionException {
        model.setKnight(new Knight(View.FAMOUS_KNIGHT));  //set a Knight
        model.equipKnight(controller.giveAmmo());         // equip him

        double from = 0;                    // a necessary variable
        double to= 1000;                    // a necessary variable
        boolean inRange = true;             // a necessary variable

        for(Ammunition a : model.ammunitionForPrice(from,to)){
            if (a.getPrice()<from && a.getPrice()>to){
                inRange=false;
            }
        }
        Assert.assertTrue(inRange);
    }

    /**
     * This method checks presence of NoKnightException
     */
    @Test (expected = NoKnightException.class)
    public void ammunitionForPriceNoKnight() throws NoKnightException, NoAmmunitionException {
       // model.setKnight(new Knight(View.FAMOUS_KNIGHT));  //set a Knight
        model.equipKnight(controller.giveAmmo());         // equip him

        double from = 0;                    // a necessary variable
        double to= 1000;                    // a necessary variable
        model.ammunitionForPrice(from,to);


    }

    /**
     * This method checks presence of NoAmmunitionException
     */
    @Test (expected = NoAmmunitionException.class)
    public void ammunitionForPriceNoAmmunition() throws NoKnightException, NoAmmunitionException {
        model.setKnight(new Knight(View.FAMOUS_KNIGHT));  //set a Knight
        //model.equipKnight(controller.giveAmmo());         // equip him
        double from = 0;                    // a necessary variable
        double to= 1000;                    // a necessary variable
        model.ammunitionForPrice(from,to);
    }

}