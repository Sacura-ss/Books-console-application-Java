package order;

import book.Book;
import human.Client;

import java.util.Calendar;
import java.util.List;

public class Order {
    private OrderStatus status;
    private Calendar executionData;
    private Double price;
    private List<Book> orderedBooks;

    private Client client;


    private Double getTotalPrice(List<Book> orderedBooks) {
        double totalPrice = 0;
        for (Book p : orderedBooks) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }

    public Order(Calendar executionData, List<Book> orderedBooks, Client client) {
        this.executionData = executionData;
        this.price = getTotalPrice(orderedBooks);
        this.client = client;
        this.orderedBooks = orderedBooks;
        status = OrderStatus.NEW;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Calendar getExecutionData() {
        return executionData;
    }

    public void setExecutionData(Calendar executionData) {
        this.executionData = executionData;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", price=" + price +
                ", orderedBooks=" + orderedBooks +
                ", client=" + client +
                '}';
    }
}
