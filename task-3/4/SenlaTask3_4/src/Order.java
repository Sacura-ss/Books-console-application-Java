import java.util.ArrayList;

public class Order {
    private OrderStatus status;
    private ArrayList<Book> orderedBooks;

    public Order(ArrayList<Book> orderedBooks) {
        for(Book b:orderedBooks) {
            if(b.getStatus() == BookStatus.LACK) {
                BookStore.leaveRequest(b);
            }
        }
        this.orderedBooks = new ArrayList<Book>(orderedBooks);
    }

    public void setOrderStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", orderedBooks=" + orderedBooks +
                '}';
    }
}
