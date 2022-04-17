package controller.action.book;

import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ImportAllBookActivity extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        bookService.importAll("resources/books.csv");
        System.out.println("Finish import");
    }
}
