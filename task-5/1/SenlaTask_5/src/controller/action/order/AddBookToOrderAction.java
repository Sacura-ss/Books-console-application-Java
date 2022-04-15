package controller.action.order;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class AddBookToOrderAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter book id");
        Long bookId = Reader.readId();
        System.out.println("Enter order id");
        Long orderId = Reader.readId();

        if (orderService.getById(orderId) != null
                && bookService.getById(bookId) != null) {
            orderService.addBookToOrder(orderId, bookId);
            System.out.println("Book " + bookId + " was added to order " + orderId);
        } else {
            System.out.println("No such id");
        }

    }
}
