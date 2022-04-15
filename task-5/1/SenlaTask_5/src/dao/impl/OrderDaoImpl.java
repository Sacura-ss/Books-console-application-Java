package dao.impl;

import dao.OrderDao;
import dao.entity.Book;
import dao.entity.Client;
import dao.entity.Order;
import dao.entity.OrderStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderDaoImpl extends AbstractDaoImpl<Order>
        implements OrderDao {

    @Override
    protected void updateFields(Order oldEntity, Order newEntity) {
        oldEntity.setOrderedBooks(newEntity.getOrderedBooks());
        oldEntity.setClient(newEntity.getClient());
        oldEntity.setStatus(newEntity.getStatus());
        oldEntity.setExecutionData(newEntity.getExecutionData());
    }

    @Override
    public void changeStatusById(Long id, OrderStatus status) {
        Order order = getById(id);
        order.setStatus(status);
    }

    @Override
    public void changeExecutionDataById(Long id, Calendar executionData) {
        Order order = getById(id);
        order.setExecutionData(executionData);
    }

    @Override
    public void changeOrderedBooksById(Long id, List<dao.entity.Book> orderedBooks) {
        Order order = getById(id);
        order.setOrderedBooks(orderedBooks);
    }

    @Override
    public void changeClientById(Long id, Client client) {
        Order order = getById(id);
        order.setClient(client);
    }

    @Override
    public void openOrder(Long id) {
        Order order = getById(id);
        order.setStatus(OrderStatus.NEW);
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = getById(id);
        order.setStatus(OrderStatus.CANCELED);
    }

    @Override
    public void completeOrder(Long id) {
        Order order = getById(id);
        order.setStatus(OrderStatus.COMPLETED);
    }

    @Override
    public Double getTotalPrice(Long id) {
        Order order = getById(id);
        double totalPrice = 0;
        for (Book book : order.getOrderedBooks()) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    @Override
    public List<Order> getCompletedOrder(Calendar begin, Calendar end) {
        List<Order> completedOrder = new ArrayList<Order>();
        for (Order order : getAll())
            if (OrderStatus.COMPLETED.equals(order.getStatus())
                    && order.getExecutionData().compareTo(begin) >= 0
                    && order.getExecutionData().compareTo(end) <= 0)
                completedOrder.add(order);
        return completedOrder;
    }


    @Override
    public Double getProfit(Calendar begin, Calendar end) {
        Double sum = 0.0;
        for (Order order : getCompletedOrder(begin, end))
            sum += getTotalPrice(order.getId());
        return sum;
    }

    @Override
    public Integer getAmountCompletedOrder(Calendar begin, Calendar end) {
        return getCompletedOrder(begin, end).size();
    }

    @Override
    public List<Order> sortOrderByExecutionData() {
        //List<Order> list = new ArrayList<>(getAll()).stream().sorted(new OrderExecutionDataComparator()).collect(Collectors.toList());
        List<Order> list = getAll();
        list.sort((order1, order2) -> order1.getExecutionData().compareTo(order2.getExecutionData()));
        return list;
    }

    @Override
    public List<Order> sortOrderByPrice() {
        List<Order> list = getAll();
        list.sort((order1, order2) -> order1.getPrice().compareTo(order2.getPrice()));
        return list;
    }

    @Override
    public List<Order> sortOrderByStatus() {
        List<Order> list = getAll();
        list.sort((order1, order2) -> order1.getStatus().toString().compareTo(order2.getStatus().toString()));
        return list;
    }


}
