package book;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        if (book.getPrice().compareTo(t1.getPrice()) > 0)
            return 1;
        else if (book.getPrice().compareTo(t1.getPrice()) < 0) {
            return -1;
        } else
            return 0;
    }
}
