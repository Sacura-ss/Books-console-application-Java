import java.util.Calendar;

public abstract class Flower {
    private double cost;
    private Calendar expirationDate = Calendar.getInstance();
    private Color color;

    public Flower(double cost, Color color) {
        this.cost = cost;
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getDescription();

    public boolean equals(Flower f) {
        return this.getExpirationDate() == f.getExpirationDate()
                && this.getColor() == f.getColor()
                && this.getCost() == f.getCost();
    }
}
