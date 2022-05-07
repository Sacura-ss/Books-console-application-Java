package controller.action.request;

import controller.Reader;
import controller.action.Action;

import java.io.IOException;

public class ImportRequestByIdAction extends Action {
    @Override
    public void execute() throws IOException {
        System.out.println("Enter request id");
        Long id = Reader.readId();
        requestService.importById(id, "resources/requests.csv");
        System.out.println("Finish import");
    }
}
