package controller.action.request;

import controller.action.Action;
import controller.action.IAction;
import controller.action.UniqueId;
import dao.entity.Request;

public class CreateRequestAction extends Action implements IAction {
    @Override
    public void execute() {
        Request request = new Request();
        requestService.create(request);

        System.out.println("Create " + request);
    }
}
