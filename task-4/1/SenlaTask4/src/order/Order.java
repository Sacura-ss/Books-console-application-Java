package order;

import book.Book;
import book.BookStatus;
import store.BookStore;

import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private OrderStatus status;
    private Calendar executionData;
    private Double price;
    private ArrayList<Book> orderedBooks;


    private Double getTotalPrice(ArrayList<Book> orderedBooks) {
        double totalPrice = 0;
        for(Book p: orderedBooks) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }

    public Order(Calendar executionData, ArrayList<Book> orderedBooks) {
        this.executionData = executionData;
        this.price = getTotalPrice(orderedBooks);
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

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", executionData=" + executionData +
                ", price=" + price +
                ", orderedBooks=" + orderedBooks +
                '}';
    }
}
