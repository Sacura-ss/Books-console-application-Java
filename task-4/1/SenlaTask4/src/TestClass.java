import book.Book;
import book.BookStatus;
import book.Genre;
import order.Order;
import store.BookStore;

import java.util.ArrayList;
import java.util.Calendar;

public class TestClass {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        for (int i = 0; i < 9; i++) {
            bookStore.addBookToWarehouse(new Book("Autor", "Title", "OOO", Calendar.getInstance(), 1000.00, Genre.FANTASY));
        }

        ArrayList<Book> orderBook = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            orderBook.add(new Book("Autor", "Title", "OOO", Calendar.getInstance(), 1000.00, Genre.FANTASY));
        }


        Order or = bookStore.createOrder(Calendar.getInstance() ,orderBook);
        System.out.println(bookStore);

        bookStore.cancelOrder(or);
        System.out.println(bookStore);


        orderBook.get(0).setStatus(BookStatus.LACK);
        orderBook.get(1).setStatus(BookStatus.AVAILABILITY);
        System.out.println(orderBook.get(0).getStatus());
        System.out.println(orderBook.get(1).getStatus());
        System.out.println(orderBook.get(0).getStatus().compareTo(orderBook.get(1).getStatus()));

    }
}
