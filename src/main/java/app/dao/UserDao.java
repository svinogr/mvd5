package app.dao;

import app.entity.users.User;

public interface UserDao extends BasicDao<User> {
    User getByLogin(String login);
}
