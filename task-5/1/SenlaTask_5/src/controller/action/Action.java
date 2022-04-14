package controller.action;

import dao.BookDao;
import dao.ClientDao;
import dao.OrderDao;
import dao.RequestDao;
import dao.impl.BookDaoImpl;
import dao.impl.ClientDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.RequestDaoImpl;
import service.BookService;
import service.ClientService;
import service.OrderService;
import service.RequestService;
import service.impl.BookServiceImpl;
import service.impl.ClientServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.RequestServiceImpl;


public abstract class Action {
    private static BookDao bookDao = new BookDaoImpl();
    private static ClientDao clientDao = new ClientDaoImpl();
    private static OrderDao orderDao = new OrderDaoImpl();
    private static RequestDao requestDao = new RequestDaoImpl();

    protected static BookService bookService = new BookServiceImpl(bookDao, orderDao);
    protected static ClientService clientService = new ClientServiceImpl(clientDao);
    protected static OrderService orderService = new OrderServiceImpl(orderDao, requestDao, clientDao, bookDao);
    protected static RequestService requestService = new RequestServiceImpl(requestDao, bookDao);
}
