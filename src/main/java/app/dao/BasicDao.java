package app.dao;

import javax.persistence.OptimisticLockException;

public interface BasicDao<T> {

    T getById(long id);
    T create(T object);
    boolean delete(T object);
    boolean update(T object);
}
