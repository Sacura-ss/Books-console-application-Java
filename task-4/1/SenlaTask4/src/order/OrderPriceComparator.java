package order;

import java.util.Comparator;

public class OrderPriceComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        if (order1.getPrice().compareTo(order2.getPrice()) > 0)
            return 1;
        else if (order1.getPrice().compareTo(order2.getPrice()) < 0) {
            return -1;
        } else
            return 0;
    }
}
