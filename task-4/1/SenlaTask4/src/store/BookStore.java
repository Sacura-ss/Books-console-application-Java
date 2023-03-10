package store;


import book.Book;
import book.BookAuthorComparator;
import book.BookPriceComparator;
import book.BookStatus;
import book.BookStatusComparator;
import book.BookTitleComparator;
import book.BookYearOfPublishingComparator;
import human.Client;
import order.Order;
import order.OrderExecutionDataComparator;
import order.OrderPriceComparator;
import order.OrderStatus;
import order.OrderStatusComparator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class BookStore {

    private Set<Book> books = new HashSet<Book>(); //Список всех книг в магазине
    private List<Order> orderList = new ArrayList<Order>(); //Список заказов
    private static Map<Book, Integer> requestMap = new HashMap(); //Список запрошенных книг и колчисетво запросов к каждой

    public static void leaveRequest(Book book) {
        if (requestMap.get(book) == null)
            requestMap.put(book, 1);
        else
            requestMap.put(book, requestMap.get(book) + 1);
    }

    private void checkOrder(List<Book> orderedBooks) {
        for (Book b : orderedBooks) {
            if (b.getStatus() == BookStatus.LACK) {
                BookStore.leaveRequest(b);
            }
        }
    }

    public Order createOrder(Calendar executionData, List<Book> orderBooks, Client client) {
        Order order = new Order(executionData, orderBooks, client);
        checkOrder(orderBooks);
        orderList.add(order);
        return order;
    }

    public void cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELED);
    }

    public void removeFromWarehouse(Book book) {
        //books.remove(book);
        book.setStatus(BookStatus.LACK);
    }

    public void addBookToWarehouse(Book book) {
        books.add(book);
        book.setStatus(BookStatus.AVAILABILITY);
    }

    public Set<Book> sortBooksByAuthor(Set<Book> unsorted) {
        SortedSet<Book> sorted = new TreeSet<Book>(new BookAuthorComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public Set<Book> sortBooksByTitle(Set<Book> unsorted) {
        SortedSet<Book> sorted = new TreeSet<Book>(new BookTitleComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public Set<Book> sortBooksByYearOfPublishing(Set<Book> unsorted) {
        SortedSet<Book> sorted = new TreeSet<Book>(new BookYearOfPublishingComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public Set<Book> sortBooksByStatus(Set<Book> unsorted) {
        SortedSet<Book> sorted = new TreeSet<Book>(new BookStatusComparator());
        sorted.addAll(unsorted);
        return sorted;
    }

    public Set<Book> sortBooksByPrice(Set<Book> unsortedBooks) {
        SortedSet<Book> sorted = new TreeSet<Book>(new BookPriceComparator());
        sorted.addAll(unsortedBooks);
        return sorted;
    }

    public List<Order> sortOrderByDataExecutionData(List<Order> unsorted) {
        List<Order> sorted = new ArrayList<Order>(unsorted);
        sorted.sort(new OrderExecutionDataComparator());
        return sorted;
    }

    public List<Order> sortOrderByPrice(List<Order> unsorted) {
        List<Order> sorted = new ArrayList<Order>(unsorted);
        sorted.sort(new OrderPriceComparator());
        return sorted;
    }

    public List<Order> sortOrderByStatus(List<Order> unsorted) {
        List<Order> sorted = new ArrayList<Order>(unsorted);
        sorted.sort(new OrderStatusComparator());
        return sorted;
    }

    public Set<Map.Entry<Book, Integer>> sortRequestByAmount(Map<Book, Integer> unsorted) {
        SortedSet<Map.Entry<Book, Integer>> sorted = new TreeSet<Map.Entry<Book, Integer>>(Map.Entry.comparingByValue());
        sorted.addAll(unsorted.entrySet());
        return sorted;
    }

    public Map<Book, Integer> sortRequestByTitle(Map<Book, Integer> unsorted) {
        Map<Book, Integer> sorted = new TreeMap<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getTitle().compareTo(book2.getTitle());
            }
        });
        return sorted;

    }

    public Map<Book, Integer> sortRequestByAuthor(Map<Book, Integer> unsorted) {
        Map<Book, Integer> sorted = new TreeMap<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getAuthor().compareTo(book2.getAuthor());
            }
        });
        return sorted;
    }

    public List<Order> getCompletedOrder(Calendar begin, Calendar end) {
        List<Order> completedOrder = new ArrayList<Order>();
        for (Order o : orderList)
            if (OrderStatus.COMPLETED.equals(o.getStatus())
                    && o.getExecutionData().compareTo(begin) >= 0
                    && o.getExecutionData().compareTo(end) <= 0)
                completedOrder.add(o);
        return completedOrder;
    }

    public Integer getAmountCompletedOrder(Calendar begin, Calendar end) {
        return getCompletedOrder(begin, end).size();
    }

    public Double getProfit(Calendar begin, Calendar end) {
        Double sum = 0.0;
        for (Order o : this.getCompletedOrder(begin, end))
            sum += o.getPrice();
        return sum;
    }

    public List<Book> getIrrelevantBooks() {
        List<Book> oldBooks = new ArrayList<>(books);
        Calendar lostTime = Calendar.getInstance();
        lostTime.add(Calendar.MONTH, -6);
        List<Order> orders = getCompletedOrder(lostTime, Calendar.getInstance());
        for (Order o : orders)
            for (Book orB : o.getOrderedBooks()) {
                oldBooks.remove(orB);
            }
        return oldBooks;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public static Map<Book, Integer> getRequestMap() {
        return requestMap;
    }

    @Override
    public String toString() {
        return "store.BookStore{" +
                "books=" + books +
                ", orderList=" + orderList +
                '}';
    }
}
