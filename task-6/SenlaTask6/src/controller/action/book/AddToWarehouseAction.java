package controller.action.book;

import controller.Reader;
import controller.action.Action;

public class AddToWarehouseAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter book id");
        long id = Reader.readId();

        if (bookService.getById(id) != null) {
            bookService.addToWarehouse(id);
            System.out.println("Book " + id + " have status AVAILABILITY,");
        } else {
            System.out.println("No such id");
        }

    }
}
