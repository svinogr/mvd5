package app.controllers;

import app.dao.CarDao;
import app.dao.UserDao;
import app.entity.cars.car.Car;
import app.entity.cars.car.PassportData;
import app.entity.cars.owner.Owner;
import app.entity.users.User;
import app.services.CarService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    CarDao carDao;

    @Autowired
    CarService carService;

    @Autowired
    UserDao userDao;

//    @RequestMapping(value = "/info/")
//    public @ResponseBody
//    String getVersionProgramm(HttpServletResponse response) {
//        response.setStatus(200);
//
//        User user = userDao.getByLogin("admin");
//        System.out.println(user.getId() + " " + user.getPassword());
//
//        return "version is 1.0" + user.getLogin();
//    }

    @RequestMapping(value = "/adminc/")
    public @ResponseBody
    String getVersionProgramm2(HttpServletResponse response) {
        // response.setStatus(200);
        User user = new User();
        user.setPassword("123");
        user.setLogin("admin");
        userService.createAdmin(user);

        return "created " + user.getLogin();
    }


    @RequestMapping(value = "/carc/")
    public @ResponseBody
    Car getVersionProgramm3(HttpServletResponse response) {
        // response.setStatus(200);

        Car car = carDao.getById(5);
        User user = userDao.getById(1);

        System.out.println(user.getId());
//       Car car = new Car();
//        Owner owner = new Owner();
//        PassportData passportData = new PassportData();
//        car.setOwner(owner);
//        car.setPassportData(passportData);
//        carService.create(car);
        System.out.println(car.getId() + "" + car.getOwner());
        return car;
    }
}
