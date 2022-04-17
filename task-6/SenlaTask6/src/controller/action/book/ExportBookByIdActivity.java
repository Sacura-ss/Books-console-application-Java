package controller.action.book;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ExportBookByIdActivity extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        System.out.println("Enter book id");
        Long id = Reader.readId();
        bookService.exportById(id, "resources/books.csv");
        System.out.println("Finish export");
    }
}
