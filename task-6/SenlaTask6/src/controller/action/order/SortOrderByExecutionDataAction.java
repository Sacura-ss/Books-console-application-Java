package controller.action.order;

import controller.action.Action;
import controller.action.IAction;

public class SortOrderByExecutionDataAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println(orderService.sortOrderByExecutionData());
    }
}
