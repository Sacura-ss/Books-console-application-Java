package dao;

import dao.entity.Book;
import dao.entity.BookGenre;
import dao.entity.BookStatus;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface BookDao extends AbstractDao<Book> {
    void changeAuthorById(Long id, String author);

    void changeTitleById(Long id, String title);

    void changePublishingHouseById(Long id, String publishingHouse);

    void changeYearOfPublishingById(Long id, Calendar yearOfPublishing);

    void changePriceById(Long id, Double price);

    void changeAmountRequestById(Long id, Integer amountRequest);

    void changeGenreById(Long id, BookGenre genre);

    void changeStatusById(Long id, BookStatus status);

    void removeFromWarehouse(Long id);

    void addToWarehouse(Long id);

    List<Book> sortBooksByAuthor();

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByYearOfPublishing();

    List<Book> sortBooksByStatus();

    List<Book> sortBooksByPrice();

}
