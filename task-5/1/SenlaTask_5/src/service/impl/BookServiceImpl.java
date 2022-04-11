package service.impl;

import dao.BookDao;
import dao.OrderDao;
import dao.entity.Book;
import dao.entity.Order;
import dao.impl.BookDaoImpl;
import service.BookService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookServiceImpl extends AbstractServiceImpl<Book, BookDao> implements BookService {
    private BookDao bookDao;
    protected OrderDao orderDao;

    public BookServiceImpl(BookDao bookDao, OrderDao orderDao) {
        super(bookDao);
        this.bookDao = bookDao;
        this.orderDao = orderDao;
    }

    @Override
    public List<Book> getIrrelevantBooks() {
        List<Book> oldBooks = new ArrayList<>(bookDao.getAll());
        Calendar lostTime = Calendar.getInstance();
        lostTime.add(Calendar.MONTH, -6);
        List<Order> orders = orderDao.getCompletedOrder(lostTime, Calendar.getInstance());
        for (Order order : orders)
            for (Book orderedBook : order.getOrderedBooks()) {
                oldBooks.remove(orderedBook);
            }
        return oldBooks;
    }

    @Override
    public void removeFromWarehouse(Long id) {
        bookDao.removeFromWarehouse(id);
    }

    @Override
    public void addToWarehouse(Long id) {
        bookDao.addToWarehouse(id);
    }

    @Override
    public List<Book> sortBooksByAuthor() {
        return bookDao.sortBooksByAuthor();
    }

    @Override
    public List<Book> sortBooksByTitle() {
        return bookDao.sortBooksByTitle();
    }

    @Override
    public List<Book> sortBooksByYearOfPublishing() {
        return bookDao.sortBooksByYearOfPublishing();
    }

    @Override
    public List<Book> sortBooksByStatus() {
        return bookDao.sortBooksByStatus();
    }

    @Override
    public List<Book> sortBooksByPrice() {
        return bookDao.sortBooksByPrice();
    }
}
