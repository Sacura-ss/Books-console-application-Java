package controller.action.client;

import controller.action.Action;
import controller.action.IAction;

public class ExportAllClientAction extends Action implements IAction {
    @Override
    public void execute() {
        clientService.exportAll("resources/clients.csv");
        System.out.println("Finish export");
    }
}
