import book.Book;
import book.Genre;
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

         // books that the buyer wants to buy
         ArrayList<Book> wantBooks = new ArrayList<>();
         wantBooks.add(book1);
         wantBooks.add(book2);
         wantBooks.add(book3);

         //generate orders
         Calendar executionData = Calendar.getInstance();
         executionData.add(Calendar.DATE, 5);
         Order order1 = bookStore.createOrder(executionData , wantBooks);
         order1.setStatus(OrderStatus.COMPLETED);

         bookStore.removeFromWarehouse(book2);
         Order order2 = bookStore.createOrder(executionData, wantBooks);
         
         System.out.println(bookStore.sortBooksByPrice(bookStore.getBooks()));
         System.out.println(bookStore.sortOrderByStatus(bookStore.getOrderList()));
         System.out.println(bookStore.sortRequestByAmount(bookStore.getRequestList()));


     }
}
