package book;

import java.util.Comparator;

public class BookYearOfPublishingComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        if (book.getYearOfPublishing().YEAR > t1.getYearOfPublishing().YEAR)
            return 1;
        else if (book.getYearOfPublishing().YEAR < t1.getYearOfPublishing().YEAR) {
            return -1;
        } else
            return 0;
    }
}