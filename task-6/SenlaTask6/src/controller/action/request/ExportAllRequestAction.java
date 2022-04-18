package controller.action.request;

import controller.action.Action;

import java.io.IOException;

public class ExportAllRequestAction extends Action {
    @Override
    public void execute() throws IOException {
        requestService.exportAll("resources/requests.csv");
        System.out.println("Finish export");
    }
}
