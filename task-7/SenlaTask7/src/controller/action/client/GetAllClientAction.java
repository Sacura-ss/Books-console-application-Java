package controller.action.client;

import controller.action.Action;

public class GetAllClientAction extends Action {
    @Override
    public void execute() {
        System.out.println(clientService.getAll());
    }
}
