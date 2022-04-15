package dao.entity;

public class Request extends AbstractEntity{
    Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
