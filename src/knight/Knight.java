package knight;

import java.util.List;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 * This class describes a knight. The knight has a name and ammunition.
 */
public class Knight {


    private String name;                    //name
    private List<Ammunition> ammunition;    //list of knight's ammunition

    /**
     * Constructor
     * @param name is name of Knight
     */
    public Knight(String name) {
        this.name = "sir " + name;
    }




    //setter & getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ammunition> getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(List<Ammunition> ammunition) {
        this.ammunition = ammunition;
    }

    @Override
    public String toString() {
        return "Knight " +
                name +
                "Has ammunition: " + ammunition +
                '}';
    }
}
