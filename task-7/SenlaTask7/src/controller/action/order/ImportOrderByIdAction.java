package controller.action.order;

import controller.Reader;
import controller.action.Action;

import java.io.IOException;

public class ImportOrderByIdAction extends Action {
    @Override
    public void execute() throws IOException {
        System.out.println("Enter order id");
        Long id = Reader.readId();
        orderService.importById(id, "resources/orders.csv");
        System.out.println("Finish import");
    }
}
