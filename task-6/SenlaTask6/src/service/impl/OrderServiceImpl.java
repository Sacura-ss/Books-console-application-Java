package service.impl;

import dao.BookDao;
import dao.ClientDao;
import dao.OrderDao;
import dao.RequestDao;
import dao.entity.Book;
import dao.entity.BookStatus;
import dao.entity.Client;
import dao.entity.Order;
import dao.entity.Request;
import service.OrderService;

import java.util.Calendar;
import java.util.List;

public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderDao>
        implements OrderService {

    private OrderDao orderDao;
    private RequestDao requestDao;

    private ClientDao clientDao;

    private BookDao bookDao;

    public OrderServiceImpl(OrderDao orderDao, RequestDao requestDao,
                            ClientDao clientDao, BookDao bookDao) {
        super(orderDao);
        this.orderDao = orderDao;
        this.requestDao = requestDao;
        this.clientDao = clientDao;
        this.bookDao = bookDao;
    }


    @Override
    public void addBookToOrder(Long orderId, Long bookId) {
        Order order = orderDao.getById(orderId);
        Book book = bookDao.getById(bookId);
        order.getOrderedBooks().add(book);
    }

    @Override
    public void addClientToOrder(Long orderId, Long clientId) {
        Order order = orderDao.getById(orderId);
        Client client = clientDao.getById(clientId);
        order.setClient(client);
    }

    @Override
    public void checkOrderForLeaveRequest(Long orderId, Long requestId) {
        Order order = orderDao.getById(orderId);
        Request request = requestDao.getById(requestId);
        for(Book book: order.getOrderedBooks()) {
            if(book.getStatus().equals(BookStatus.LACK)) {
                request.setBook(book);
            }
        }
    }

    @Override
    public void openOrder(Long id) {
        orderDao.openOrder(id);
    }

    @Override
    public void cancelOrder(Long id) {
        orderDao.cancelOrder(id);
    }

    @Override
    public void completeOrder(Long id) {
        orderDao.completeOrder(id);
    }

    @Override
    public Double getTotalPrice(Long id) {
        return orderDao.getTotalPrice(id);
    }

    @Override
    public List<Order> getCompletedOrder(Calendar begin, Calendar end) {
        return orderDao.getCompletedOrder(begin, end);
    }

    @Override
    public Double getProfit(Calendar begin, Calendar end) {
        return orderDao.getProfit(begin, end);
    }

    @Override
    public Integer getAmountCompletedOrder(Calendar begin, Calendar end) {
        return orderDao.getAmountCompletedOrder(begin, end);
    }

    @Override
    public List<Order> sortOrderByExecutionData() {
        return orderDao.sortOrderByExecutionData();
    }

    @Override
    public List<Order> sortOrderByPrice() {
        return orderDao.sortOrderByPrice();
    }

    @Override
    public List<Order> sortOrderByStatus() {
        return orderDao.sortOrderByStatus();
    }

    @Override
    public void importFromLine(String line) {

    }
}
