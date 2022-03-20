import java.util.ArrayList;
import java.util.stream.Collectors;

public class Bouquet {
    private final ArrayList<Flower> flowers = new ArrayList<>();

    public boolean addFlower(Flower f) {
        if ((java.util.Calendar.getInstance()).compareTo(f.getExpirationDate()) > 0) {
            return false;
        } else {
            flowers.add(f);
            return true;
        }
    }

    public boolean removeFlower(Flower f) {
        for (Flower flower : flowers) {
            if (flower.equals(f)) {
                flowers.remove(flower);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Flower> getBouquet() {
        return flowers;
    }

    @Override
    public String toString() {
        return flowers.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
