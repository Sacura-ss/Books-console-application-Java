package dao.impl;

import dao.AbstractDao;
import dao.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDaoImpl<T extends AbstractEntity>
        implements AbstractDao<T> {
    private List<T> repository = new ArrayList<>();

    protected abstract void updateFields(T oldEntity, T newEntity);
    @Override
    public T getById(Long id) {
        for(T entity: repository) {
            if(entity.getId().equals(id))
                return entity;
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void deleteById(Long id) {
        T entity = getById(id);
        repository.remove(entity);
    }

    @Override
    public void create(T entity) {
        repository.add(entity);
    }

    public void update(Long id, T newEntity) {
        T entity = getById(id);
        updateFields(entity, newEntity);
    }
}
