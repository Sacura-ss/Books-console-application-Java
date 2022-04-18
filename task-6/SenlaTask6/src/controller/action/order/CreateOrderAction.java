package controller.action.order;

import controller.action.Action;
import dao.entity.Order;

public class CreateOrderAction extends Action {
    @Override
    public void execute() {
        Order order = new Order();
        orderService.create(order);
        System.out.println("Create " + order);
    }
}

