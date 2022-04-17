package controller.action.order;

import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ImportAllOrderAction extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        orderService.importAll("resources/orders.csv");
        System.out.println("Finish import");
    }
}
