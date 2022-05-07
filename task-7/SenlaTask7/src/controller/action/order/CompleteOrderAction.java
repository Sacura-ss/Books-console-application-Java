package controller.action.order;

import controller.Reader;
import controller.action.Action;

public class CompleteOrderAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter order id");
        Long orderId = Reader.readId();

        if (orderService.getById(orderId) != null) {
            orderService.completeOrder(orderId);
            System.out.println("Order " + orderId + " have status COMPLETED");
        } else {
            System.out.println("No such id");
        }

    }
}
