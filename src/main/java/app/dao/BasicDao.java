package app.dao;

public interface BasicDao<T> {

    T getById(long id);
}
