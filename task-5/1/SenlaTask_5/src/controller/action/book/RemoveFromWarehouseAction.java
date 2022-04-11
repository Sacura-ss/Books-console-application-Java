package controller.action.book;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class RemoveFromWarehouseAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter book id");
        long id = Reader.readId();

        if (bookService.getById(id) != null) {
            bookService.removeFromWarehouse(id);
            System.out.println("Book " + id + " have status LACK");
        } else {
            System.out.println("No such id");
        }
    }
}
