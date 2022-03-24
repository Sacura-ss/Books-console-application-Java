public class Seller {

    public double calculateTheCost(Bouquet bt) {
        double cost = 0.0;
        for (Flower flower : bt.getBouquet()) {
            cost += flower.getCost();
        }
        return cost;
    }

}
