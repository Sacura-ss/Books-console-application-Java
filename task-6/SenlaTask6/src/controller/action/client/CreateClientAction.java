package controller.action.client;

import controller.Reader;
import controller.action.Action;
import dao.entity.Client;

public class CreateClientAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter client name");
        String name = Reader.readName();
        System.out.println("Enter client surname");
        String surname = Reader.readName();
        System.out.println("Enter client email");
        String email = Reader.readEmail();

        Client client = new Client();
        client.setFirstName(name);
        client.setSecondName(surname);
        client.setEmail(email);

        clientService.create(client);
        System.out.println(clientService.getAll());
        System.out.println("Create " + client);
    }
}
