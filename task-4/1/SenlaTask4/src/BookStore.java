import java.util.ArrayList;

public class BookStore {
    private ArrayList<Book> books = new ArrayList<>(); //Список всех книг в магазине
    private ArrayList<Order> orderList = new ArrayList<>(); //Список заказов
    private static ArrayList<Book> queryList = new ArrayList<>(); //Список запрошенных книг

    public static void leaveRequest(Book book) {
        if (!queryList.contains(book))
            queryList.add(book);
    }

    public Order createOrder(ArrayList<Book> orderBooks) {
        Order order = new Order(orderBooks);
        order.setOrderStatus(OrderStatus.NEW);
        orderList.add(order);
        return order;
    }

    public void cancelOrder(Order order) {
        order.setOrderStatus(OrderStatus.CANCELED);
    }

    public void removeFromWarehouse(Book book) {
        books.remove(book);
        book.setStatus(BookStatus.LACK);
    }

    public void addBookToWarehouse(Book book) {
        books.add(book);
        book.setStatus(BookStatus.AVAILABILITY);
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "books=" + books +
                ", orderList=" + orderList +
                '}';
    }
}
