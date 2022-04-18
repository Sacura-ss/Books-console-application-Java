package controller.action.client;

import controller.action.Action;

public class ExportAllClientAction extends Action {
    @Override
    public void execute() {
        clientService.exportAll("resources/clients.csv");
        System.out.println("Finish export");
    }
}
