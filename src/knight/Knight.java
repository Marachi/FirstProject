package knight;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Knight {
    private String name;
    private List<Ammunition> ammunition;

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
