package service;

import dao.entity.Order;

import java.util.Calendar;
import java.util.List;

public interface OrderService extends AbstractService<Order> {
    void addBookToOrder(Long orderId, Long bookId);

    void addClientToOrder(Long orderId, Long clientId);

    void checkOrderForLeaveRequest(Long orderId, Long requestId);

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
