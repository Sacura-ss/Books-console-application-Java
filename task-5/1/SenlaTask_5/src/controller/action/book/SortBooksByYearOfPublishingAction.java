package controller.action.book;

import controller.action.Action;
import controller.action.IAction;

public class SortBooksByYearOfPublishingAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println(bookService.sortBooksByYearOfPublishing());
    }
}
