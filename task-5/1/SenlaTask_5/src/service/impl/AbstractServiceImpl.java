package service.impl;

import dao.AbstractDao;
import dao.entity.AbstractEntity;
import dao.impl.AbstractDaoImpl;
import service.AbstractService;

import java.util.List;

public class AbstractServiceImpl<T extends AbstractEntity, D extends AbstractDao<T>>
        implements AbstractService<T> {

    private D defaultDao;

    public AbstractServiceImpl(D defaultDao) {
        this.defaultDao = defaultDao;
    }

    @Override
    public T getById(Long id) {
        return defaultDao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return defaultDao.getAll();
    }

    @Override
    public void deleteById(Long id) {
        defaultDao.deleteById(id);
    }

    @Override
    public void update(Long id, T entity) {
        defaultDao.update(id, entity);
    }

    @Override
    public void create(T entity) {
        defaultDao.create(entity);
    }
}
