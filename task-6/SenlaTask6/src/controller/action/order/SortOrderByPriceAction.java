package controller.action.order;

import controller.action.Action;

public class SortOrderByPriceAction extends Action {
    @Override
    public void execute() {
        System.out.println(orderService.sortOrderByPrice());
    }
}
