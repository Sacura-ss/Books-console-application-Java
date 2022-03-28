package order;

import java.util.Comparator;

public class OrderPriceComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        return order1.getPrice().compareTo(order2.getPrice());
    }
}
