package controller.action.order;

import controller.action.Action;

public class SortOrderByExecutionDataAction extends Action {
    @Override
    public void execute() {
        System.out.println(orderService.sortOrderByExecutionData());
    }
}
