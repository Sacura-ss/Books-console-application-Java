package controller.action.request;

import controller.action.Action;
import dao.entity.Request;

public class CreateRequestAction extends Action {
    @Override
    public void execute() {
        Request request = new Request();
        requestService.create(request);

        System.out.println("Create " + request);
    }
}
