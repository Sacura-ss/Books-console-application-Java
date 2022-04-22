package controller.action.order;

import controller.action.Action;

public class SortOrderByStatusAction extends Action {
    @Override
    public void execute() {
        System.out.println(orderService.sortOrderByStatus());
    }
}
