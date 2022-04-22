package dao;

import dao.entity.Human;

public interface AbstractHumanDao<T extends Human> extends AbstractDao<T>{
    void changeFirstNameById(Long id, String firstName);
    void changeSecondNameById(Long id, String secondName);
}
