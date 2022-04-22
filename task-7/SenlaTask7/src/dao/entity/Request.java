package dao.entity;

public class Request extends AbstractEntity {
    Book book;
    boolean isCompleted;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Request: " + book + " " + isCompleted;
    }
}
