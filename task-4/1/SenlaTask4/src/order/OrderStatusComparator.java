package order;

import java.util.Comparator;

public class OrderStatusComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        return order1.getStatus().toString().compareTo(order2.getStatus().toString());
    }
}
