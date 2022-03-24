package book;

import book.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        if(book.getTitle().compareTo(t1.getTitle()) > 0)
            return 1;
        else if(book.getTitle().compareTo(t1.getTitle()) < 0) {
            return -1;
        }
        else
            return 0;
    }
}
