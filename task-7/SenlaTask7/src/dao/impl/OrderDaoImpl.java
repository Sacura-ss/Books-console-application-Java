package dao.impl;

import dao.OrderDao;
import dao.entity.Book;
import dao.entity.Client;
import dao.entity.Order;
import dao.entity.OrderStatus;

import java.io.IOException;
import java.io.ObjectInput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

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
        for (Order order : getAll()) {
            if (OrderStatus.COMPLETED.equals(order.getStatus())
                    && order.getExecutionData().compareTo(begin) >= 0
                    && order.getExecutionData().compareTo(end) <= 0) {
                completedOrder.add(order);
            }
        }
        return completedOrder;
    }


    @Override
    public Double getProfit(Calendar begin, Calendar end) {
        Double sum = 0.0;
        for (Order order : getCompletedOrder(begin, end)) {
            sum += getTotalPrice(order.getId());
        }
        return sum;
    }

    @Override
    public Integer getAmountCompletedOrder(Calendar begin, Calendar end) {
        return getCompletedOrder(begin, end).size();
    }

    @Override
    public List<Order> sortOrderByExecutionData() {
        return getAll().stream()
                .sorted((order1, order2) -> order1.getExecutionData().compareTo(order2.getExecutionData()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> sortOrderByPrice() {
        return getAll().stream()
                .sorted((order1, order2) -> order1.getPrice().compareTo(order2.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> sortOrderByStatus() {
        return getAll().stream()
                .sorted((order1, order2) -> order1.getStatus().toString().compareTo(order2.getStatus().toString()))
                .collect(Collectors.toList());

    }

    @Override
    public String exportToLine(Long id) {
        Order order = getById(id);
        String line = "";
        StringBuilder builder = new StringBuilder();
        builder.append(order.getId());
        builder.append(',');
        builder.append(order.getStatus());
        builder.append(',');
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        builder.append(format.format(order.getExecutionData().getTime()));

        builder.append(",[");
        int i = order.getOrderedBooks().size();
        for (Book book : order.getOrderedBooks()) {
            builder.append(book.getId());
            i--;
            if (i != 0) {
                builder.append(", ");
            }
        }
        builder.append("],");

        builder.append(order.getClient().getId());
        builder.append(',');
        builder.append(order.getPrice());
        builder.append('\n');
        line = builder.toString();
        return line;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        int count = objectInput.readInt();
        for (int i = 0; i < count; i++) {
            Order order = new Order();
            create(order);
            order.readExternal(objectInput);
        }
    }
}
