package controller.action.book;

import controller.Reader;
import controller.action.Action;

public class UpdateBookAction extends Action {

    @Override
    public void execute() {
        System.out.println("Enter first id");
        Long firstId = Reader.readId();
        System.out.println("Enter second id");
        Long secondId = Reader.readId();

        if (bookService.getById(firstId) != null
                && bookService.getById(secondId) != null) {
            bookService.update(firstId, bookService.getById(secondId));
            System.out.println("Update book " + firstId + " to book " + secondId);
        } else {
            System.out.println("No such id");
        }

    }
}
