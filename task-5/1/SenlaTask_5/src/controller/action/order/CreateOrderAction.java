package controller.action.order;

import controller.action.Action;
import controller.action.IAction;
import controller.action.UniqueId;
import dao.entity.Order;

public class CreateOrderAction extends Action implements IAction {
    @Override
    public void execute() {
        Order order = new Order();
        orderService.create(order);
        System.out.println("Create " + order);
    }
}

