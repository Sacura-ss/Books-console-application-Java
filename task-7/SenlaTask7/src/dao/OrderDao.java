package dao;

import dao.entity.Book;
import dao.entity.Client;
import dao.entity.Order;
import dao.entity.OrderStatus;

import java.util.Calendar;
import java.util.List;

public interface OrderDao extends AbstractDao<Order> {
    void changeStatusById(Long id, OrderStatus status);

    void changeExecutionDataById(Long id, Calendar executionData);

    void changeOrderedBooksById(Long id, List<Book> orderedBooks);

    void changeClientById(Long id, Client client);

    void openOrder(Long id);

    void cancelOrder(Long id);

    void completeOrder(Long id);

    Double getTotalPrice(Long id);

    List<Order> getCompletedOrder(Calendar begin, Calendar end);
    Double getProfit(Calendar begin, Calendar end);
    Integer getAmountCompletedOrder(Calendar begin, Calendar end);

    List<Order> sortOrderByExecutionData();

    List<Order> sortOrderByPrice();

    public List<Order> sortOrderByStatus();


}
