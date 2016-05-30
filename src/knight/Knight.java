package knight;

import java.util.Collection;
import java.util.Set;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Knight {
    private String name;
    private Collection ammunition;

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

    public Collection getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Collection ammunition) {
        this.ammunition = ammunition;
    }

    @Override
    public String toString() {
        return "I'm a knight, " +
                name + '\n' +
                "My ammunition: " + ammunition +
                '}';
    }
}
