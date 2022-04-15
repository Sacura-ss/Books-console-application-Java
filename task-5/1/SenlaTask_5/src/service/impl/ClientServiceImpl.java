package service.impl;

import dao.ClientDao;
import dao.entity.Client;
import service.ClientService;

public class ClientServiceImpl extends AbstractServiceImpl<Client, ClientDao> implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        super(clientDao);
        this.clientDao = clientDao;
    }
}
