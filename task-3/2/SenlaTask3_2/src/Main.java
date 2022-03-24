public class Main {
    public static void main(String[] args) {
        Seller s = new Seller();
        Bouquet bt = new Bouquet();
        bt.addFlower(new Rose(12.0, Color.LILAC, true));
        bt.addFlower(new Pion(10.0, Color.PEACH, "Japanese"));
        bt.addFlower(new Chysanthenum(11.0, Color.BLUE, false));
        System.out.println(bt);
        System.out.println(s.calculateTheCost(bt));
    }
}
