package controller.action.request;

import controller.action.Action;

public class SortRequestByAmountAction extends Action {
    @Override
    public void execute() {
        System.out.println(requestService.sortRequestByAmount());
    }
}
