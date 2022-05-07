package service;

import dao.entity.Book;

import java.util.List;

public interface BookService extends AbstractService<Book> {
    List<Book> getIrrelevantBooks();

    void removeFromWarehouse(Long id);

    void addToWarehouse(Long id);

    List<Book> sortBooksByAuthor();

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByYearOfPublishing();

    List<Book> sortBooksByStatus();

    List<Book> sortBooksByPrice();

    void completeRequestByBookId(Long bookId);
}
