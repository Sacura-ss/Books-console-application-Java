package controller.action.request;

import controller.Reader;
import controller.action.Action;
import controller.action.IAction;

public class DeleteRequestAction extends Action implements IAction {
    @Override
    public void execute() {
        System.out.println("Enter id");
        Long id = Reader.readId();

        if (requestService.getById(id) != null) {
            requestService.deleteById(id);
            System.out.println("Request " + id + " was deleted");
        } else {
            System.out.println("No such id");
        }

    }
}
