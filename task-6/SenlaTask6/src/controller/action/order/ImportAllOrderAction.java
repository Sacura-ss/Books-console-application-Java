package controller.action.order;

import controller.action.Action;

import java.io.IOException;

public class ImportAllOrderAction extends Action {
    @Override
    public void execute() throws IOException {
        orderService.importAll("resources/orders.csv");
        System.out.println("Finish import");
    }
}
