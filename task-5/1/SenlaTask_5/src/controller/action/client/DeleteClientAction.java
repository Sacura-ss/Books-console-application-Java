package controller.action.client;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class DeleteClientAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter id");
        Long id = Reader.readId();

        if (clientService.getById(id) != null) {
            clientService.deleteById(id);
            System.out.println("Client " + id + " was deleted");
        } else {
            System.out.println("No such client");
        }


    }
}
