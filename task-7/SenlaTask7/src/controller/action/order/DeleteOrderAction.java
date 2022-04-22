package controller.action.order;

import controller.Reader;
import controller.action.Action;

public class DeleteOrderAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter order id");
        Long enteredId = Reader.readId();

        if (orderService.getById(enteredId) != null) {
            orderService.deleteById(enteredId);
            System.out.println("Order" + enteredId + " was deleted");
        } else {
            System.out.println("No such id");
        }

    }
}
