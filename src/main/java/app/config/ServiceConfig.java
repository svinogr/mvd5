package app.config;

import app.services.CarService;
import app.services.UserService;
import app.services.ValidService;
import app.services.serviceImpl.CarServiceImpl;
import app.services.serviceImpl.UserServiceImpl;
import app.services.serviceImpl.ValidUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"app.services.*"})
public class ServiceConfig {

    @Bean
    public ValidService validService() {
        return new ValidUserImpl();
    }

    @Bean
    public UserService userService(){return new UserServiceImpl();
    }

    @Bean
    public CarService carService() {
        return new CarServiceImpl();
    }
}
