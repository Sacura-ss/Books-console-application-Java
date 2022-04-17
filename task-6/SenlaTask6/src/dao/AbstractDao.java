package dao;

import dao.entity.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity>{
    T getById(Long id);
    List<T> getAll();
    void deleteById(Long id);
    void update(Long id, T entity);
    void create(T entity);
    String exportToLine(Long id);

}
