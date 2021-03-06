package app.dao;

import javax.persistence.OptimisticLockException;
import java.util.List;

public interface BasicDao<T> {

    T getById(long id);
    T create(T object);
    boolean delete(T object);
    boolean update(T object);

    List<T> getAll();
}
