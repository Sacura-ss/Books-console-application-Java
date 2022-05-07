package dao.entity;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
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

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(getId());
        objectOutput.writeUTF(getStatus().toString());
        objectOutput.writeObject(getExecutionData());
        objectOutput.writeObject(getOrderedBooks());
        objectOutput.writeObject(getClient());
        objectOutput.writeDouble(getPrice());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        setId(objectInput.readLong());
        setStatus(OrderStatus.valueOf(objectInput.readUTF()));
        setExecutionData((Calendar) objectInput.readObject());
        setOrderedBooks((List<Book>) objectInput.readObject());
        setClient((Client) objectInput.readObject());
        setPrice(objectInput.readDouble());

    }
}
