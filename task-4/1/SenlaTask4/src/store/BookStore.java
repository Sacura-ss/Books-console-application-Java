package store;

import book.*;
import order.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

public class BookStore {
    private TreeSet<Book> books = new TreeSet<Book>(new BookTitleComparator()); //Список всех книг в магазине
    private ArrayList<Order> orderList = new ArrayList<>(); //Список заказов
    private static ArrayList<Book> queryList = new ArrayList<>(); //Список запрошенных книг

    public static void leaveRequest(Book book) {
        if (!queryList.contains(book))
            queryList.add(book);
    }

    //TODO: статус в общей библиотеке или в заказе
    private void checkOrder(ArrayList<Book> orderedBooks) {
        for (Book b : orderedBooks) {
            if (b.getStatus() == BookStatus.LACK) {
                BookStore.leaveRequest(b);
            }
        }
    }

    public Order createOrder(Calendar executionData, ArrayList<Book> orderBooks) {
        Order order = new Order(executionData, orderBooks);
        checkOrder(orderBooks);
        orderList.add(order);
        return order;
    }

    public void cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELED);
    }

    public void removeFromWarehouse(Book book) {
        books.remove(book);
        book.setStatus(BookStatus.LACK);
    }

    public void addBookToWarehouse(Book book) {
        books.add(book);
        book.setStatus(BookStatus.AVAILABILITY);
    }

    public TreeSet<Book> sortBooksByAuthor(TreeSet<Book> unsorted) {
        TreeSet<Book> sorted = new TreeSet<Book>(new BookAuthorComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public TreeSet<Book> sortBooksByTitle(TreeSet<Book> unsorted) {
        TreeSet<Book> sorted = new TreeSet<Book>(new BookTitleComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public TreeSet<Book> sortBooksByYearOfPublishing(TreeSet<Book> unsorted) {
        TreeSet<Book> sorted = new TreeSet<Book>(new BookYearOfPublishingComparator());
        sorted.addAll(unsorted);
        return sorted;
    }
    public TreeSet<Book> sortBooksByStatus(TreeSet<Book> unsorted) {
        TreeSet<Book> sorted = new TreeSet<Book>(new BookStatusComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public TreeSet<Order> sortOrderByDataExecutionData(TreeSet<Order> unsorted) {
        TreeSet<Order> sorted = new TreeSet<Order>(new OrderExecutionDataComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public TreeSet<Order> sortOrderByPrice(TreeSet<Order> unsorted) {
        TreeSet<Order> sorted = new TreeSet<Order>(new OrderPriceComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public TreeSet<Order> sortOrderByStatus(TreeSet<Order> unsorted) {
        TreeSet<Order> sorted = new TreeSet<Order>(new OrderStatusComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public TreeSet<Book> sortBooksByPrice(TreeSet<Book> unsortedBooks) {
        TreeSet<Book> sorted = new TreeSet<Book>(new BookPriceComparator());
        sorted.addAll(unsortedBooks);
        return sorted;
    }

    @Override
    public String toString() {
        return "store.BookStore{" +
                "books=" + books +
                ", orderList=" + orderList +
                '}';
    }
}
