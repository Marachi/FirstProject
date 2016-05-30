package knight;

import java.util.Map;
import java.util.Set;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Knight {
    private String name;
    private Set ammo;

    enum Slots{
        HEAD,
        SHOULDERS,
        BODY,
        HANDS,
        ARMS,
        FEETS,
        LEGS
    }

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

    public Set getAmmo() {
        return ammo;
    }

    public void setAmmo(Set ammo) {
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return "I'm a knight, " +
                name + '\n' +
                "My ammunition: " + ammo +
                '}';
    }
}
