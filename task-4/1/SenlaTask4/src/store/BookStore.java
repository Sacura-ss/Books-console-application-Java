package store;

import book.*;
import order.*;

import java.util.*;

public class BookStore {

    private TreeSet<Book> books = new TreeSet<Book>(new BookTitleComparator()); //Список всех книг в магазине
    private ArrayList<Order> orderList = new ArrayList<>(); //Список заказов
    private static TreeMap<Book, Integer> requestList = new TreeMap(new Comparator<Book>() {
        @Override
        public int compare(Book book, Book t1) {
            if (book.getTitle().compareTo(t1.getTitle()) > 0)
                return 1;
            else if (book.getTitle().compareTo(t1.getTitle()) < 0) {
                return -1;
            } else
                return 0;
        }
    }); //Список запрошенных книг

    public static void leaveRequest(Book book) {
        if (requestList.get(book) == null)
            requestList.put(book, 1);
        else
            requestList.put(book, requestList.get(book) + 1);
    }

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
        //books.remove(book);
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

    public TreeSet<Book> sortBooksByPrice(TreeSet<Book> unsortedBooks) {
        TreeSet<Book> sorted = new TreeSet<Book>(new BookPriceComparator());
        sorted.addAll(unsortedBooks);
        return sorted;
    }

    public ArrayList<Order> sortOrderByDataExecutionData(ArrayList<Order> unsorted) {
        ArrayList<Order> sorted = new ArrayList<Order>(unsorted);
        sorted.sort(new OrderExecutionDataComparator());
        return sorted;
    }

    public ArrayList<Order> sortOrderByPrice(ArrayList<Order> unsorted) {
        ArrayList<Order> sorted = new ArrayList<Order>(unsorted);
        sorted.sort(new OrderPriceComparator());
        return sorted;
    }

    public ArrayList<Order> sortOrderByStatus(ArrayList<Order> unsorted) {
        ArrayList<Order> sorted = new ArrayList<Order>(unsorted);
        sorted.sort(new OrderStatusComparator());
        return sorted;
    }

    public SortedSet<Map.Entry<Book, Integer>> sortRequestByAmount(TreeMap<Book, Integer> unsorted) {
        SortedSet<Map.Entry<Book, Integer>> sorted = new TreeSet<Map.Entry<Book, Integer>>(
                new Comparator<Map.Entry<Book, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Book, Integer> r1,
                                       Map.Entry<Book, Integer> r2) {
                        return r1.getValue().compareTo(r2.getValue());
                    }
                });
        sorted.addAll(unsorted.entrySet());
        return sorted;
    }

    public TreeMap<Book, Integer> sortRequestByTitle(TreeMap<Book, Integer> unsorted) {
        return unsorted;
        //it is already sorted TreeMap))
    }

    public TreeMap<Book, Integer> sortRequestByAuthor(TreeMap<Book, Integer> unsorted) {
        TreeMap<Book, Integer> sorted = new TreeMap<>(new Comparator<Book>() {
            @Override
            public int compare(Book book, Book t1) {
                if (book.getAuthor().compareTo(t1.getAuthor()) > 0)
                    return 1;
                else if (book.getAuthor().compareTo(t1.getAuthor()) < 0) {
                    return -1;
                } else
                    return 0;
            }
        });
        return sorted;
    }

    public ArrayList<Order> getCompletedOrder(Calendar begin, Calendar end) {
        ArrayList<Order> completedOrder = new ArrayList<Order>();
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

    public ArrayList<Book> getIrrelevantBooks() {
        ArrayList<Book> oldBooks = new ArrayList<>(books);
        Calendar lostTime = Calendar.getInstance();
        lostTime.add(Calendar.MONTH, -6);
        ArrayList<Order> orders = getCompletedOrder(lostTime, Calendar.getInstance());
        for (Order o : orders)
            for (Book orB : o.getOrderedBooks()) {
                oldBooks.remove(orB);
            }
        return oldBooks;
    }

    public TreeSet<Book> getBooks() {
        return books;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public static TreeMap<Book, Integer> getRequestList() {
        return requestList;
    }

    @Override
    public String toString() {
        return "store.BookStore{" +
                "books=" + books +
                ", orderList=" + orderList +
                '}';
    }
}
