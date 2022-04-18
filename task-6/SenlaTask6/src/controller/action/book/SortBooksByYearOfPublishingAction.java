package controller.action.book;

import controller.action.Action;

public class SortBooksByYearOfPublishingAction extends Action {
    @Override
    public void execute() {
        System.out.println(bookService.sortBooksByYearOfPublishing());
    }
}
