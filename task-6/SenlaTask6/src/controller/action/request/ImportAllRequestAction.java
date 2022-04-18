package controller.action.request;

import controller.action.Action;

import java.io.IOException;

public class ImportAllRequestAction extends Action {
    @Override
    public void execute() throws IOException {
        requestService.importAll("resources/requests.csv");
        System.out.println("Finish import");
    }
}
