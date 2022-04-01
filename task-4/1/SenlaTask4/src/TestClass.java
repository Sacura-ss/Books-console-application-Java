import book.Book;
import book.Genre;
import human.Client;
import order.Order;
import order.OrderStatus;
import store.BookStore;

import java.util.ArrayList;
import java.util.Calendar;

public class TestClass {
    public static void main(String[] args) {

        Book book1 = new Book("Author1", "Title1", "OOO", Calendar.getInstance(), 1000.00, Genre.FANTASY);
        Book book2 = new Book("Author2", "Title2", "OOO", Calendar.getInstance(), 800.00, Genre.COOK);
        Book book3 = new Book("Author3", "Title3", "OOO", Calendar.getInstance(), 600.00, Genre.BUSINESS);

        //generate warehouse of store
        BookStore bookStore = new BookStore();
        bookStore.addBookToWarehouse(book1);
        bookStore.addBookToWarehouse(book2);
        bookStore.addBookToWarehouse(book3);

        bookStore.removeFromWarehouse(book3);
        bookStore.removeFromWarehouse(book2);

        // books that the buyer wants to buy
        ArrayList<Book> wantBooks = new ArrayList<>();
        wantBooks.add(book1);
        wantBooks.add(book2);
        wantBooks.add(book3);

        //generate clients
        Client client1 = new Client("Ulfric", " Stormcloak", "ulfric@gmail.com");
        Client client2 = new Client("Tullius", " General", "tutu@gmail.com");

        //generate orders
        Calendar executionData = Calendar.getInstance();
        executionData.add(Calendar.DATE, 5);
        Order order1 = bookStore.createOrder(executionData, wantBooks, client1);
        order1.setStatus(OrderStatus.CANCELED);

        ArrayList<Book> wantBooks2 = new ArrayList<>(wantBooks);
        wantBooks2.remove(book3);
        Order order2 = bookStore.createOrder(executionData, wantBooks2, client2);

        //print store сondition
        System.out.println(bookStore.sortBooksByPrice(bookStore.getBooks()));
        System.out.println(bookStore.sortOrderByStatus(bookStore.getOrderList()));
        System.out.println("ggg");
        System.out.println(bookStore.sortRequestByAmount(bookStore.getRequestMap()));

        //complete orders
        order1.setStatus(OrderStatus.COMPLETED);
        order2.setStatus(OrderStatus.COMPLETED);

        //print sorted completed orders
        Calendar begin = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        begin.add(Calendar.DATE, -5);
        end.add(Calendar.DATE, +5);
        System.out.println(bookStore.sortOrderByPrice(bookStore.getCompletedOrder(begin, end)));

        //test other methods
        System.out.println(bookStore.getProfit(begin, end));
        System.out.println(bookStore.getAmountCompletedOrder(begin, end));
        System.out.println(bookStore.getIrrelevantBooks());
        System.out.println(order1);
        System.out.println(book1);

    }
}
