package knight;

/**
 * Created by potaychuk on 30.05.2016.
 */
public class Ammunition implements Comparable{
    private Type type;
    private double weight;
    private double price;


    public Ammunition(double weight, double price, Type type) {
        this.weight = weight;
        this.price = price;
        this.type = type;
    }



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
