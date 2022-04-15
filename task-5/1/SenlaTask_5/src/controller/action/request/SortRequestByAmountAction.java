package controller.action.request;

import controller.action.Action;
import controller.action.IAction;

public class SortRequestByAmountAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println(requestService.sortRequestByAmount());
    }
}
