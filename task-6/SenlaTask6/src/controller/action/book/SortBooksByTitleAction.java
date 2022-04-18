package controller.action.book;

import controller.action.Action;

public class SortBooksByTitleAction extends Action {
    @Override
    public void execute() {
        System.out.println(bookService.sortBooksByTitle());
    }
}
