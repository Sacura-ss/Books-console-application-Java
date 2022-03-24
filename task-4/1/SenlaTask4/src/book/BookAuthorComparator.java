package book;

import book.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        if(book.getAuthor().compareTo(t1.getAuthor()) > 0)
            return 1;
        else if(book.getAuthor().compareTo(t1.getAuthor()) < 0) {
            return -1;
        }
        else
            return 0;
    }
}
