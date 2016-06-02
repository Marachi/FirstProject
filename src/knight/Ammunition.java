package knight;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 * This class describes ammunition (weight, price and type).
 */
public class Ammunition implements Comparable{


    private Type type;          //type of ammunition
    private double weight;      //weight
    private double price;       //price

    /**
     * Constructor
     * sets weight, price and type
     * @param weight is weight
     * @param price is price
     * @param type  is type
     */
    public Ammunition(double weight, double price, Type type) {
        this.weight = weight;
        this.price = price;
        this.type = type;
    }


    /**
     * Contains types of ammunition
     */
    public enum Type {
        HELM,SHOULDERS,CHEST,PANTS,GLOVES,BOOTS,BRACERS, SWORD
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ammunition ammo = (Ammunition) o;
        return type == ammo.type;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "type=" + type +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        Ammunition temp = (Ammunition)o;
        if (temp.getWeight()>getWeight()){
            return -1;
        }
        else if (temp.getWeight()<getWeight()){
            return 1;
        }else {
            return 0;
        }
    }

    public Type getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
