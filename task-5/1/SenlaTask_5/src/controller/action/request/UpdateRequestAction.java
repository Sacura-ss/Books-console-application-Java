package controller.action.request;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class UpdateRequestAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter first id");
        Long firstId = Reader.readId();
        System.out.println("Enter second id");
        Long secondId = Reader.readId();

        if (requestService.getById(firstId) != null
                && requestService.getById(secondId) != null) {
            requestService.update(firstId, requestService.getById(secondId));
            System.out.println("Update request " + firstId + " to request " + secondId);
        } else {
            System.out.println("No such id");
        }

    }
}
