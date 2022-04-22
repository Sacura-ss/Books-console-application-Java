package controller.action.book;

import controller.Reader;
import controller.action.Action;

public class DeleteBookAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter id");
        Long id = Reader.readId();

        if (bookService.getById(id) != null) {
            bookService.deleteById(id);
            System.out.println("Book " + id + " was deleted");
        } else {
            System.out.println("No such id");
        }

    }
}
