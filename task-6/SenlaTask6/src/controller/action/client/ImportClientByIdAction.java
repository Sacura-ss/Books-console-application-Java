package controller.action.client;

import controller.Reader;
import controller.action.Action;

public class ImportClientByIdAction extends Action {

    @Override
    public void execute() {
        System.out.println("Enter client id");
        Long id = Reader.readId();
        clientService.importById(id, "resources/clients.csv");
        System.out.println("Finish import");
    }
}
