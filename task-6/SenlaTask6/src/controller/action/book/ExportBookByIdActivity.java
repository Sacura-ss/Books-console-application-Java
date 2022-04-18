package controller.action.book;

import controller.Reader;
import controller.action.Action;

import java.io.IOException;

public class ExportBookByIdActivity extends Action {
    @Override
    public void execute() throws IOException {
        System.out.println("Enter book id");
        Long id = Reader.readId();
        bookService.exportById(id, "resources/books.csv");
        System.out.println("Finish export");
    }
}
