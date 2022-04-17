package service.impl;

import dao.BookDao;
import dao.ClientDao;
import dao.OrderDao;
import dao.RequestDao;
import dao.entity.Book;
import dao.entity.BookStatus;
import dao.entity.Client;
import dao.entity.Order;
import dao.entity.OrderStatus;
import dao.entity.Request;
import service.OrderService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    private String checkData(String data) {
        Integer end = data.length() - 1;
        if (data.charAt(0) == '[' ){
            data = data.substring(1);
            end--;
        }
        if (data.charAt(end) == ']') {
            data = data.substring(0, end);
            end--;
        }
        if (data.charAt(0) == ' ') {
            data = data.substring(1);
            end--;
        }
        return data;
    }
    @Override
    public void importFromLine(String line) {
        Order order = new Order();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        Integer startOrderBooks = line.indexOf('[');
        Integer endOrderBooks = line.indexOf(']');
        int index = 0;
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == 0)
                order.setId(Long.parseLong(data));
            else if (index == 1)
                order.setStatus(OrderStatus.valueOf(data));
            else if (index == 2) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = format.parse(data);
                    Calendar yearOfPublishing = Calendar.getInstance();
                    yearOfPublishing.setTime(date);
                    order.setExecutionData(yearOfPublishing);
                } catch (ParseException e) {
                }
            }
            else if (index == 3) {
                List<Book> books = new ArrayList<>();
                while (data.charAt(data.length() - 1) != ']') {
                    data = checkData(data);
                    books.add(bookDao.getById(Long.parseLong(data)));
                    data = scanner.next();
                }
                data = checkData(data);
                books.add(bookDao.getById(Long.parseLong(data)));
                order.setOrderedBooks(books);
            }
            else if (index == 4) {
                order.setClient(clientDao.getById(Long.parseLong(data)));
            }
            else if (index == 5) {
                order.setPrice(Double.parseDouble(data));
            }
            index++;
        }
        index = 0;
        create(order);
    }
}
