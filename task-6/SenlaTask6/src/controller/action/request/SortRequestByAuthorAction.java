package controller.action.request;

import controller.action.Action;

public class SortRequestByAuthorAction extends Action {
    @Override
    public void execute() {
        System.out.println(requestService.sortRequestByAuthor());
    }
}
