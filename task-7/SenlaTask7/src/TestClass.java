import controller.Builder;
import controller.MenuController;
import controller.Navigator;
import controller.action.Action;
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


public class TestClass {


    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        RequestDao requestDao = new RequestDaoImpl();

        ClientService clientService = new ClientServiceImpl(clientDao);
        BookService bookService = new BookServiceImpl(bookDao, orderDao,requestDao);
        OrderService orderService = new OrderServiceImpl(orderDao, requestDao, clientDao, bookDao);
        RequestService requestService = new RequestServiceImpl(requestDao, bookDao);

        Action.setClientService(clientService);
        Action.setBookService(bookService);
        Action.setOrderService(orderService);
        Action.setRequestService(requestService);

        Builder builder = new Builder();
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuController(builder, navigator);
        menuController.run();

    }
}
