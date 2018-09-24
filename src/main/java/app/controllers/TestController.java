package app.controllers;

import app.dao.UserDao;
import app.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class TestController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/info/")
    public @ResponseBody
    String getVersionProgramm(HttpServletResponse response) {
        response.setStatus(200);

        User user = userDao.getByLogin("admin");
        System.out.println(user.getId() + " " + user.getPassword());

        return "version is 1.0" + user.getLogin();
    }

    @RequestMapping(value = "/admin/")
    public @ResponseBody
    String getVersionProgramm2(HttpServletResponse response) {
       // response.setStatus(200);

        User user = userDao.getByLogin("admin");
        System.out.println(user.getId() + " " + user.getPassword());

        return "version is 1.0" + user.getLogin();
    }


    @RequestMapping(value = "/admin/2")
    public @ResponseBody
    String getVersionProgramm3(HttpServletResponse response) {
        // response.setStatus(200);

        User user = userDao.getByLogin("admin");
        System.out.println(user.getId() + " " + user.getPassword());

        return "version is 1.0" + 3;
    }
}
