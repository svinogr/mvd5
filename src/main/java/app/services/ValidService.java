package app.services;

import app.entity.users.User;
import org.springframework.validation.BindingResult;

public interface ValidService {
    User validUser(User user, BindingResult bindingResult);
}
