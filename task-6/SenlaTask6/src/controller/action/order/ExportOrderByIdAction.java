package controller.action.order;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ExportOrderByIdAction extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        System.out.println("Enter order id");
        Long id = Reader.readId();
        orderService.exportById(id, "resources/orders.csv");
        System.out.println("Finish export");
    }
}
