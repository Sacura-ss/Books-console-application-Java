package controller.action.order;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class AddClientToOrderAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter client id");
        Long clientId = Reader.readId();
        System.out.println("Enter order id");
        Long orderId = Reader.readId();

        if (orderService.getById(orderId) != null
                && clientService.getById(clientId) != null) {
            orderService.addClientToOrder(orderId, clientId);
            System.out.println("Client " + clientId + " was added to order " + orderId);
        } else {
            System.out.println("No such id");
        }
    }
}
