package app.services;

import app.entity.users.User;
import org.springframework.stereotype.Component;



public interface UserService {
    User getUserByLogin();
    User createUser(User user);
    User createAdmin(User user);
    boolean update(User user);
    boolean delete(User user);

}
