package controller.action.client;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class UpdateClientAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter first id");
        Long firstId = Reader.readId();
        System.out.println("Enter second id");
        Long secondId = Reader.readId();

        if (clientService.getById(firstId) != null
                && clientService.getById(secondId) != null) {
            clientService.update(firstId, clientService.getById(secondId));
            System.out.println("Update client " + firstId + " to client " + secondId);
        } else {
            System.out.println("No such id");
        }

    }
}
