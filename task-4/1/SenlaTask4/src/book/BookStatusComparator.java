package book;

import book.Book;

import java.util.Comparator;

public class BookStatusComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        if(book.getStatus().compareTo(t1.getStatus()) > 0)
            return 1;
        else if(book.getStatus().compareTo(t1.getStatus()) < 0) {
            return -1;
        }
        else
            return 0;
    }
}