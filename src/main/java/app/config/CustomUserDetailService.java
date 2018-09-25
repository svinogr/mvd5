//package app.config;
//
//import app.dao.UserDao;
//import app.entity.users.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//
//public class CustomUserDetailService extends JdbcDaoImpl {
//
//
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("userdetail in custom user" + " " + username);
//        UserDetails userDetails = super.loadUserByUsername(username);
//        User user  = userDao.getByLogin(username);
//        user.setUserDetails(userDetails);
//        System.out.println(userDetails.getUsername() + " - " + userDetails.getPassword() + " " + userDetails.toString());
//        return userDetails;
//    }
//}
