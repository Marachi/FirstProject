package knight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Model {

    private Knight knight;
    private List<Ammo> armory = new ArrayList<>();


    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public List<Ammo> getArmory() {
        return armory;
    }

    public void setArmory(List<Ammo> armory) {
        this.armory = armory;
    }
}
