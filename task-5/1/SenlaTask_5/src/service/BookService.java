package service;

import dao.entity.Book;

import java.util.List;

public interface BookService extends AbstractService<Book>{
    public List<Book> getIrrelevantBooks();

    void removeFromWarehouse(Long id);

    void addToWarehouse(Long id);

    public List<Book> sortBooksByAuthor();

    public List<Book> sortBooksByTitle();

    public List<Book> sortBooksByYearOfPublishing();

    public List<Book> sortBooksByStatus();

    public List<Book> sortBooksByPrice();
}
