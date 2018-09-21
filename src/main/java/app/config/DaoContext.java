package app.config;

import app.dao.BasicDao;
import app.dao.UserDao;
import app.dao.daoimpl.BasicDaoImpl;
import app.dao.daoimpl.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoContext {

    @Bean
    BasicDao basicDao(){
        return new BasicDaoImpl();
    }

    @Bean
    UserDao userDao(){
        return new UserDaoImpl();
    }
}
