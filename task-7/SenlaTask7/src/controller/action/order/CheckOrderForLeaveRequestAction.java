package controller.action.order;

import controller.Reader;
import controller.action.Action;

public class CheckOrderForLeaveRequestAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter request id");
        Long requestId = Reader.readId();
        System.out.println("Enter order id");
        Long orderId = Reader.readId();

        if (orderService.getById(orderId) != null
                && requestService.getById(requestId) != null) {
            orderService.checkOrderForLeaveRequest(orderId, requestId);
            System.out.println("Checked order " + orderId + " to make request " + requestId);
        } else {
            System.out.println("No such id");
        }

    }
}
