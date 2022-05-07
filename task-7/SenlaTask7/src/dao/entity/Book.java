package dao.entity;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Calendar;

public class Book extends AbstractEntity {
    private String author;
    private String title;
    private String publishingHouse;
    private Calendar yearOfPublishing;
    private Double price;

    private Integer amountRequest = 0;

    private BookGenre genre;
    private BookStatus status;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Calendar getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Calendar yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmountRequest() {
        return amountRequest;
    }

    public void setAmountRequest(Integer amountRequest) {
        this.amountRequest = amountRequest;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "title=" + title + " "
                + "status=" + status;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(getId());
        objectOutput.writeUTF(getAuthor());
        objectOutput.writeUTF(getTitle());
        objectOutput.writeUTF(getPublishingHouse());
        objectOutput.writeObject(getYearOfPublishing());
        objectOutput.writeDouble(getPrice());
        objectOutput.writeInt(getAmountRequest());
        objectOutput.writeUTF(getGenre().toString());
        objectOutput.writeUTF(getStatus().toString());
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        setId(objectInput.readLong());
        setAuthor(objectInput.readUTF());
        setTitle(objectInput.readUTF());
        setPublishingHouse(objectInput.readUTF());
        setYearOfPublishing((Calendar) objectInput.readObject());
        setPrice(objectInput.readDouble());
        setAmountRequest(objectInput.readInt());
        setGenre(BookGenre.valueOf(objectInput.readUTF()));
        setStatus(BookStatus.valueOf(objectInput.readUTF()));
    }
}
