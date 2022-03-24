package order;

import book.Book;

import java.util.Comparator;

public class OrderStatusComparator  implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        if(order1.getStatus().compareTo(order2.getStatus()) > 0)
            return 1;
        else if(order1.getStatus().compareTo(order2.getStatus()) < 0) {
            return -1;
        }
        else
            return 0;
    }
}
