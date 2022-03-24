package book;

import java.util.Calendar;

public class Book{
    private String author;
    private String title;
    private String publishingHouse;
    private Calendar yearOfPublishing;
    private Double price;

    private Genre genre;
    private BookStatus status;

    public Book(String author, String title, String publishingHouse, Calendar yearOfPublishing,
                double price, Genre genre) {
        this.author = author;
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.genre = genre;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Calendar yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "book.Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", genre=" + genre +
                ", status=" + status +
                '}';
    }
}
