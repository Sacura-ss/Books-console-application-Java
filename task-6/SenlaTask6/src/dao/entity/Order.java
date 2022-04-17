package dao.entity;

import java.util.Calendar;
import java.util.List;

public class Order extends AbstractEntity {
    private OrderStatus status;
    private Calendar executionData = Calendar.getInstance();
    private List<Book> orderedBooks;
    private Client client;

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<Book> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
