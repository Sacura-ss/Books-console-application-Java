package controller.action.order;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class GetTotalPriceAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter order id");
        Long orderId = Reader.readId();

        if (orderService.getById(orderId) != null) {
            System.out.println(orderService.getTotalPrice(orderId));
        } else {
            System.out.println("No such id");
        }

    }
}
