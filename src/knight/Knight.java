package knight;

import java.util.List;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 * This class describes a knight. The knight has a name and ammunition.
 */
public class Knight {

    /**
     * Name
     */
    private String name;

    /**
     * Ammunition
     */
    private List<Ammunition> ammunition;

    /**
     * Constructor
     * @param name is name of Knight
     */
    public Knight(String name) {
        this.name = "sir " + name;
    }

    @Override
    public String toString() {
        return "Knight " +
                name +
                "Has ammunition: " + ammunition +
                '}';
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

}
