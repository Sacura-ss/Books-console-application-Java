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


        Order or = bookStore.createOrder(orderBook);
        System.out.println(bookStore);

        bookStore.cancelOrder(or);
        System.out.println(bookStore);
        System.out.println(or.getOrderStatus());

    }
}
