package book;

import java.util.Comparator;

public class BookStatusComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getStatus().toString().compareTo(book2.getStatus().toString());
    }
}