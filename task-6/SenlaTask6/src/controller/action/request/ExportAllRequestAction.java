package controller.action.request;

import controller.action.Action;
import controller.action.IAction;

import java.io.IOException;

public class ExportAllRequestAction extends Action implements IAction {
    @Override
    public void execute() throws IOException {
        requestService.exportAll("resources/requests.csv");
        System.out.println("Finish export");
    }
}
