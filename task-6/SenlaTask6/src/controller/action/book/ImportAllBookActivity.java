package controller.action.book;

import controller.action.Action;

import java.io.IOException;

public class ImportAllBookActivity extends Action {
    @Override
    public void execute() throws IOException {
        bookService.importAll("resources/books.csv");
        System.out.println("Finish import");
    }
}
