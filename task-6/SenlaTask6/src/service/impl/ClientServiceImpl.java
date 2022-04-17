package service.impl;

import dao.ClientDao;
import dao.entity.Client;
import service.ClientService;
import service.Importable;

import java.util.Scanner;

public class ClientServiceImpl extends AbstractServiceImpl<Client, ClientDao>
        implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        super(clientDao);
        this.clientDao = clientDao;
    }
    @Override
    public void importFromLine(String line) {
        Client client = new Client();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        int index = 0;
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == 0)
                client.setId(Long.parseLong(data));
            else if (index == 1)
                client.setFirstName(data);
            else if (index == 2)
                client.setSecondName(data);
            else if (index == 3)
                client.setEmail(data);
            index++;
        }
        index = 0;
        create(client);
    }
}
