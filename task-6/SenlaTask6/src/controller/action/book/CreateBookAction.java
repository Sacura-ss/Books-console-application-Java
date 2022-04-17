package controller.action.book;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;
import dao.entity.Book;
import dao.entity.BookGenre;

import java.util.Calendar;

public class CreateBookAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter book author");
        String author = Reader.readName();
        System.out.println("Enter book title");
        String title = Reader.readName();
        System.out.println("Enter book publishing house");
        String publishingHouse = Reader.readName();
        System.out.println("Enter date of publishing in the format yyyy-MM-dd");
        Calendar yearOfPublishing = Reader.readCalendar();
        System.out.println("Enter book price");
        Double price = Reader.readPrice();
        System.out.println("Enter book genre");
        BookGenre bookGenre = Reader.readBookGenre();

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublishingHouse(publishingHouse);
        book.setYearOfPublishing(yearOfPublishing);
        book.setPrice(price);
        book.setGenre(bookGenre);

        bookService.create(book);
        System.out.println("Create " + book);
    }
}
