package controller.action.book;

import controller.action.Action;

public class SortBooksByPriceAction extends Action {
    @Override
    public void execute() {
        System.out.println(bookService.sortBooksByPrice());
    }
}
