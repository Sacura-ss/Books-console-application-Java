package controller.action;

import service.BookService;
import service.ClientService;
import service.OrderService;
import service.RequestService;


public abstract class Action implements IAction {
    protected static ClientService clientService;
    protected static BookService bookService;
    protected static OrderService orderService;
    protected static RequestService requestService;


    public static void setClientService(ClientService clientService) {
        Action.clientService = clientService;
    }

    public static void setBookService(BookService bookService) {
        Action.bookService = bookService;
    }

    public static void setOrderService(OrderService orderService) {
        Action.orderService = orderService;
    }

    public static void setRequestService(RequestService requestService) {
        Action.requestService = requestService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public RequestService getRequestService() {
        return requestService;
    }
}
