package controller.action.order;

import controller.Reader;
import controller.action.Action;

public class UpdateOrderAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter first id");
        Long firstId = Reader.readId();
        System.out.println("Enter second id");
        Long secondId = Reader.readId();

        if (orderService.getById(firstId) != null
                && orderService.getById(secondId) != null) {
            orderService.update(firstId, orderService.getById(secondId));
            System.out.println("Update order " + firstId + " to order " + secondId);
        } else {
            System.out.println("No such id");
        }

    }
}
