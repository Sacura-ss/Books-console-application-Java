import java.util.Calendar;

public class Book {
    private String author;
    private String title;
    private String publishingHouse;
    private Calendar yearOfPublishing;
    private double price;

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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
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
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", price=" + price +
                ", genre=" + genre +
                ", status=" + status +
                '}';
    }
}
