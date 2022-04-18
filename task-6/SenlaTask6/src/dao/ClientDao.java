package dao;

import dao.entity.Client;
import dao.impl.AbstractDaoImpl;

public interface ClientDao extends AbstractHumanDao<Client> {
    boolean changeEmailById(Long id, String email);
    void changeFirstNameById(Long id, String firstName);

    void changeSecondNameById(Long id, String secondName);
}
