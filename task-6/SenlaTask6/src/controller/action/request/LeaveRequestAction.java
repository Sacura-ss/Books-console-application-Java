package controller.action.request;

import controller.Reader;
import controller.action.Action;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;

public class LeaveRequestAction extends Action {

    @Override
    public void execute() {
        System.out.println("Enter request id");
        Long requestId = Reader.readId();
        System.out.println("Enter book id");
        Long bookId = Reader.readId();

        OrderDao orderDao = new OrderDaoImpl();
        if (requestService.getById(requestId) != null
                && bookService.getById(bookId) != null) {
            requestService.leaveRequest(requestId, bookId);
            System.out.println("Leave request " + requestId + " for book " + bookId);
        } else {
            System.out.println("No such id");
        }

    }
}
