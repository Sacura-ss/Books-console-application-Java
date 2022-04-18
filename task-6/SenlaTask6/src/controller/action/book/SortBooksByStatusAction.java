package controller.action.book;

import controller.action.Action;

public class SortBooksByStatusAction extends Action {
    @Override
    public void execute() {
        System.out.println(bookService.sortBooksByStatus());
    }
}
