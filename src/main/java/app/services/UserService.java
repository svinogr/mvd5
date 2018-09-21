package app.services;

import app.entity.users.User;
import org.springframework.stereotype.Component;

public interface UserService {
    User getUserByLogin();

}
