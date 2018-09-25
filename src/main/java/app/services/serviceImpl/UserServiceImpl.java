package app.services.serviceImpl;


import app.dao.UserDao;
import app.entity.users.User;
import app.entity.roles.EnumRole;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User getUserByLogin() {
        return null;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(EnumRole.ROLE_USER.name());
        User createUser = userDao.create(user);
        securityFields(user);
        return createUser;
    }

    @Override
    public User createAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(EnumRole.ROLE_ADMIN.name());
        User createUser = userDao.create(user);
        securityFields(user);
        return createUser;
    }

    @Override
    public boolean update(User user) {
      boolean update =  userDao.update(user);
     securityFields(user);
      return update;
    }

    @Override
    public boolean delete(User user) {
        boolean delete = userDao.delete(user);
        return delete;
    }

    private void securityFields(User user){
        user.setPassword("");
        user.setRole("");
        user.setRole("");

    }
}
