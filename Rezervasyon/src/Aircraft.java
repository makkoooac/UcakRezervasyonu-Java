
import java.util.Random;

public class Aircraft {
    private String name;
    private int capacity;
    private int speed;
    private String classes;
    private double price;
    
    public int getCapacity() {
        return capacity;
    }
    public Aircraft(String name, int capacity, int speed, String classes) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.classes = classes;
        this.price = new Random().nextInt(7186 - 1132) + 1132;
    }

    @Override
    public String toString() {
        return "UÇAK MODEL = " + name +
                " | KAPASİTE = " + capacity +
                " | HIZ = " + speed + " km/h" +
                " | SINIF = " + classes +
                " | ÜCRET: " + price + "\n";
    }
}