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


public class Action {
    private BookDao bookDao = new BookDaoImpl();
    private ClientDao clientDao = new ClientDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private RequestDao requestDao = new RequestDaoImpl();

    protected BookService bookService = new BookServiceImpl(bookDao, orderDao);
    protected ClientService clientService = new ClientServiceImpl(clientDao);
    protected OrderService orderService = new OrderServiceImpl(orderDao, requestDao, clientDao, bookDao);
    protected RequestService requestService = new RequestServiceImpl(requestDao, bookDao);
}
