package controller.action.book;

import controller.action.Action;

public class GetIrrelevantBooksAction extends Action {
    @Override
    public void execute() {
        System.out.println(bookService.getIrrelevantBooks());
    }
}
