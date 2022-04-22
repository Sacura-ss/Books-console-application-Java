package controller.action.book;

import controller.action.Action;

import java.io.IOException;

public class ExportAllBookAction extends Action {
    @Override
    public void execute() throws IOException {
        bookService.exportAll("resources/books.csv");
        System.out.println("Finish export");
    }
}
