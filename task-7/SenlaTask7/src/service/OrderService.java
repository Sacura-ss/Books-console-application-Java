package service;

import dao.entity.Order;

import java.util.Calendar;
import java.util.List;

public interface OrderService extends AbstractService<Order> {
    void addBookToOrder(Long orderId, Long bookId);

    void addClientToOrder(Long orderId, Long clientId);

    void checkOrderForLeaveRequest(Long orderId, Long requestId);

    void openOrder(Long id);

    void cancelOrder(Long id);

    void completeOrder(Long id);

    Double getTotalPrice(Long id);

    List<Order> getCompletedOrder(Calendar begin, Calendar end);

    Double getProfit(Calendar begin, Calendar end);

    Integer getAmountCompletedOrder(Calendar begin, Calendar end);

    List<Order> sortOrderByExecutionData();

    List<Order> sortOrderByPrice();

    List<Order> sortOrderByStatus();

    void updateLinksForBooks();

    void updateLinksForClients();
}
