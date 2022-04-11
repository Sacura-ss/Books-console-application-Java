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

    public void openOrder(Long id);

    public void cancelOrder(Long id);

    public void completeOrder(Long id);

    public Double getTotalPrice(Long id);

    public List<Order> getCompletedOrder(Calendar begin, Calendar end);
    public Double getProfit(Calendar begin, Calendar end);
    public Integer getAmountCompletedOrder(Calendar begin, Calendar end);

    public List<Order> sortOrderByExecutionData();

    public List<Order> sortOrderByPrice();

    public List<Order> sortOrderByStatus();


}
