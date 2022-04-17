package controller.action.order;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class CancelOrderAction extends Action implements IAction {

    @Override
    public void execute() {
        System.out.println("Enter order id");
        Long orderId = Reader.readId();

        if (orderService.getById(orderId) != null) {
            orderService.cancelOrder(orderId);
            System.out.println("Order " + orderId + " have status CANCELED");
        } else {
            System.out.println("No such id");
        }

    }
}
