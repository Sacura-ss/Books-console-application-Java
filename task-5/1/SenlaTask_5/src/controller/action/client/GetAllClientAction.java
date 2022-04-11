package controller.action.client;

import controller.action.Action;
import controller.action.IAction;

public class GetAllClientAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println(clientService.getAll());
    }
}
