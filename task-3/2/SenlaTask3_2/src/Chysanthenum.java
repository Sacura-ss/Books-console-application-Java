import java.util.Calendar;

public class Chysanthenum extends Flower {
    private final boolean isBush;

    public Chysanthenum(double cost, Color color, boolean isBush) {
        super(cost, color);
        this.isBush = isBush;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 6);
        this.setExpirationDate(cal);
    }

    @Override
    public String getDescription() {
        return "chysanthenum";
    }
}
