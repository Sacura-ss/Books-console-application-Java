import java.util.Calendar;

public class Pion extends Flower {

    String typeOfFlower;

    public Pion(double cost, Color color, String typeOfFlower) {
        super(cost, color);
        this.typeOfFlower = typeOfFlower;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        this.setExpirationDate(cal);
    }

    @Override
    public String getDescription() {
        return "peonies";
    }
}
