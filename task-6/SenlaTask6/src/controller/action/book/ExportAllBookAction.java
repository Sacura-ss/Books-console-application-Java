package controller.action.book;

import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ExportAllBookAction extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        bookService.exportAll("resources/books.csv");
        System.out.println("Finish export");
    }
}
