package controller.action.client;

import controller.action.Action;

import java.io.IOException;

public class ImportAllClientAction extends Action {
    @Override
    public void execute() throws IOException {
        clientService.importAll("resources/clients.csv");
        System.out.println("Finish import");
    }
}
