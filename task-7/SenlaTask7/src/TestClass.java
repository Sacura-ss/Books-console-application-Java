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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestClass {

    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        RequestDao requestDao = new RequestDaoImpl();

        try (ObjectInputStream bookObjectInputStream = new ObjectInputStream(new FileInputStream("resources/book.txt"));
             ObjectInputStream clientObjectInputStream = new ObjectInputStream(new FileInputStream("resources/client.txt"));
             ObjectInputStream orderObjectInputStream = new ObjectInputStream(new FileInputStream("resources/order.txt"));
             ObjectInputStream requestObjectInputStream = new ObjectInputStream(new FileInputStream("resources/request.txt"))) {
            bookDao = (BookDao) bookObjectInputStream.readObject();
            clientDao = (ClientDao) clientObjectInputStream.readObject();
            orderDao = (OrderDao) orderObjectInputStream.readObject();
            requestDao = (RequestDao) requestObjectInputStream.readObject();
        } catch (IOException e) {
            System.out.println(e);
            ;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        ClientService clientService = new ClientServiceImpl(clientDao);
        BookService bookService = new BookServiceImpl(bookDao, orderDao, requestDao);
        OrderService orderService = new OrderServiceImpl(orderDao, requestDao, clientDao, bookDao);
        RequestService requestService = new RequestServiceImpl(requestDao, bookDao);
        orderService.updateLinksForBooks();
        orderService.updateLinksForClients();
        requestService.updateLinksForBooks();

        Action.setClientService(clientService);
        Action.setBookService(bookService);
        Action.setOrderService(orderService);
        Action.setRequestService(requestService);

        Builder builder = new Builder();
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuController(builder, navigator);
        menuController.run();

        try (ObjectOutputStream bookObjectOutputStream = new ObjectOutputStream(new FileOutputStream("resources/book.txt"));
             ObjectOutputStream clientObjectOutputStream = new ObjectOutputStream(new FileOutputStream("resources/client.txt"));
             ObjectOutputStream orderObjectOutputStream = new ObjectOutputStream(new FileOutputStream("resources/order.txt"));
             ObjectOutputStream requestObjectOutputStream = new ObjectOutputStream(new FileOutputStream("resources/request.txt"))) {
            bookObjectOutputStream.writeObject(bookDao);
            clientObjectOutputStream.writeObject(clientDao);
            orderObjectOutputStream.writeObject(orderDao);
            requestObjectOutputStream.writeObject(requestDao);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
