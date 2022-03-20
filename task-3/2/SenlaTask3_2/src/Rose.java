import java.util.Calendar;

public class Rose extends Flower {

    private final boolean haveSpikes;

    public Rose(double cost, Color color, boolean haveSpikes) {
        super(cost, color);
        this.haveSpikes = haveSpikes;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        this.setExpirationDate(cal);
    }

    @Override
    public String getDescription() {
        return "rose";
    }
}
