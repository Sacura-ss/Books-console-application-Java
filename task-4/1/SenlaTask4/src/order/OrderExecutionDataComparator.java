package order;

import book.Book;

import java.util.Comparator;

public class OrderExecutionDataComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        if (order1.getExecutionData().compareTo(order2.getExecutionData()) > 0)
            return 1;
        else if (order1.getExecutionData().compareTo(order2.getExecutionData()) < 0) {
            return -1;
        } else
            return 0;
    }
}
