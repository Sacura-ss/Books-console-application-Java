package service.impl;

import dao.BookDao;
import dao.OrderDao;
import dao.entity.Book;
import dao.entity.BookGenre;
import dao.entity.BookStatus;
import dao.entity.Order;
import service.BookService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl extends AbstractServiceImpl<Book, BookDao>
        implements BookService {
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

    @Override
    public void importFromLine(String line) {
        Book book = new Book();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        int index = 0;
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == 0)
                book.setId(Long.parseLong(data));
            else if (index == 1)
                book.setAuthor(data);
            else if (index == 2)
                book.setTitle(data);
            else if (index == 3)
                book.setPublishingHouse(data);
            else if (index == 4) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = format.parse(data);
                    Calendar yearOfPublishing = Calendar.getInstance();
                    yearOfPublishing.setTime(date);
                    book.setYearOfPublishing(yearOfPublishing);
                } catch (ParseException e) {
                    System.out.println(e);
                }
            } else if (index == 5)
                book.setPrice(Double.parseDouble(data));
            else if (index == 6)
                book.setAmountRequest(Integer.parseInt(data));
            else if (index == 7)
                book.setGenre(BookGenre.valueOf(data));
            else if (index == 8)
                book.setStatus(BookStatus.valueOf(data));
            index++;
        }
        index = 0;
        createOrUpdate(book);
    }
}
