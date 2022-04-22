package controller.action.order;

import controller.action.Action;

import java.io.IOException;

public class ExportAllOrderAction extends Action {
    @Override
    public void execute() throws IOException {
        orderService.exportAll("resources/orders.csv");
        System.out.println("Finish export");
    }
}
