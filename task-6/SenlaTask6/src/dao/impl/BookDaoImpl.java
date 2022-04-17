package dao.impl;

import dao.BookDao;
import dao.entity.Book;
import dao.entity.BookGenre;
import dao.entity.BookStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookDaoImpl extends AbstractDaoImpl<Book>
        implements BookDao{

    @Override
    protected void updateFields(Book oldEntity, Book newEntity) {
        oldEntity.setAuthor(newEntity.getAuthor());
        oldEntity.setGenre(newEntity.getGenre());
        oldEntity.setPrice(newEntity.getPrice());
        oldEntity.setStatus(newEntity.getStatus());
        oldEntity.setTitle(newEntity.getTitle());
        oldEntity.setAmountRequest(newEntity.getAmountRequest());
        oldEntity.setPublishingHouse(newEntity.getPublishingHouse());
        oldEntity.setYearOfPublishing(newEntity.getYearOfPublishing());
    }

    @Override
    public void changeAuthorById(Long id, String author) {
        Book book = getById(id);
        book.setAuthor(author);
    }

    @Override
    public void changeTitleById(Long id, String title) {
        Book book = getById(id);
        book.setTitle(title);
    }

    @Override
    public void changePublishingHouseById(Long id, String publishingHouse) {
        Book book = getById(id);
        book.setPublishingHouse(publishingHouse);
    }

    @Override
    public void changeYearOfPublishingById(Long id, Calendar yearOfPublishing) {
        Book book = getById(id);
        book.setYearOfPublishing(yearOfPublishing);
    }

    @Override
    public void changePriceById(Long id, Double price) {
        Book book = getById(id);
        book.setPrice(price);
    }

    @Override
    public void changeAmountRequestById(Long id, Integer amountRequest) {
        Book book = getById(id);
        book.setAmountRequest(amountRequest);
    }

    @Override
    public void changeGenreById(Long id, BookGenre genre) {
        Book book = getById(id);
        book.setGenre(genre);
    }

    @Override
    public void changeStatusById(Long id, BookStatus status) {
        Book book = getById(id);
        book.setStatus(status);
    }
    public void removeFromWarehouse(Long id) {
        Book book = getById(id);
        book.setStatus(BookStatus.LACK);
    }

    public void addToWarehouse(Long id) {
        Book book = getById(id);
        book.setStatus(BookStatus.AVAILABILITY);
    }

    @Override
    public List<Book> sortBooksByAuthor() {
        List list = getAll();
        list.sort((Comparator<Book>) (book1, book2) -> book1.getAuthor().compareTo(book2.getAuthor()));
        return list;
    }

    @Override
    public List<Book> sortBooksByTitle() {
        List list = getAll();
        list.sort((Comparator<Book>) (book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));
        return list;
    }

    @Override
    public List<Book> sortBooksByYearOfPublishing() {
        List list = getAll();
        list.sort((Comparator<Book>) (book1, book2) -> book1.getYearOfPublishing().compareTo(book2.getYearOfPublishing()));
        return list;
    }

    @Override
    public List<Book> sortBooksByStatus() {
        List list = getAll();
        list.sort((Comparator<Book>) (book1, book2) -> book1.getStatus().toString().compareTo(book2.getStatus().toString()));
        return list;
    }

    @Override
    public List<Book> sortBooksByPrice() {
        List list = getAll();
        list.sort((Comparator<Book>) (book1, book2) -> book1.getPrice().compareTo(book2.getPrice()));
        return list;
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
                }
            }
            else if(index == 5)
                book.setPrice(Double.parseDouble(data));
            else if(index == 6)
                book.setAmountRequest(Integer.parseInt(data));
            else if(index == 7)
                book.setGenre(BookGenre.valueOf(data));
            else if(index == 8)
                book.setStatus(BookStatus.valueOf(data));
            index++;
        }
        index = 0;
        create(book);
    }

    @Override
    public String exportToLine(Long id) {
        Book book = getById(id);
        String line = "";
        StringBuilder builder = new StringBuilder();
        builder.append(book.getId());
        builder.append(',');
        builder.append(book.getAuthor());
        builder.append(',');
        builder.append(book.getTitle());
        builder.append(',');
        builder.append(book.getPublishingHouse());
        builder.append(',');
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        builder.append(format.format(book.getYearOfPublishing().getTime()));
        builder.append(',');
        builder.append(book.getPrice());
        builder.append(',');
        builder.append(book.getAmountRequest());
        builder.append(',');
        builder.append(book.getGenre());
        builder.append(',');
        builder.append(book.getStatus());
        builder.append('\n');
        line = builder.toString();
        return line;
    }
}
