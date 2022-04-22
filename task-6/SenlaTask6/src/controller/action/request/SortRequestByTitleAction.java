package controller.action.request;

import controller.action.Action;

public class SortRequestByTitleAction extends Action {
    @Override
    public void execute() {
        System.out.println(requestService.sortRequestByTitle());
    }
}
