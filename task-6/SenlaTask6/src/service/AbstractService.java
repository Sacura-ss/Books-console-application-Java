package service;

import dao.entity.AbstractEntity;

import java.util.List;

public interface AbstractService<T extends AbstractEntity> extends Exportable, Importable {
    T getById(Long id);
    List<T> getAll();
    void deleteById(Long id);
    void update(Long id, T entity);
    void create(T entity);

}
