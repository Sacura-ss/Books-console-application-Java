package controller.action.client;

import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ImportAllClientAction extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        clientService.importAll("resources/clients.csv");
        System.out.println("Finish import");
    }
}
