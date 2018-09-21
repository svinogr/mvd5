package app.dao;

import app.entity.users.User;

public interface UserDao<T> extends BasicDao<T> {
    User getByLogin(String login);
}
