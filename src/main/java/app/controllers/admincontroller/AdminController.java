package app.controllers.admincontroller;


import app.dao.UserDao;
import app.entity.users.User;
import app.entity.users.UserInfo;
import app.services.UserService;
import app.services.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    ValidService validService;

    @RequestMapping(value = "/userinfo/", method = RequestMethod.GET)
    public @ResponseBody
    List<UserInfo> getAllUserInfo(HttpServletResponse response) {
        System.out.println(2);
        List<UserInfo> list = new ArrayList<>();
        UserInfo info = new UserInfo();
        list.add(info);
        return list;
    }


    /**
     * @param user json : {"login":"login","password":"login", "role":"user/admin"}
     * @param bindingResult
     * @param response json : {"id": id,"login":"login","password":"login"}
     * @return
     */
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public @ResponseBody
    User createUser(@RequestBody @Valid User user, BindingResult bindingResult, HttpServletResponse response) {
        System.out.println("createUser");
        if (bindingResult.hasErrors()) {
            return validService.validUser(user, bindingResult);
        }

        User createdUser = null;

        if(user.getRole().equals("admin")){
            createdUser = userService.createAdmin(user);
        }

        if(user.getRole().equals("user")){
            createdUser = userService.createUser(user);
        }

        response.setStatus(201);
        response.setHeader("Location", "/api/admin/user/" + createdUser.getId());
        return createdUser;
    }

    /**
     * @param id number in bd
     * @param response
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUserOrAdmin(@PathVariable long id, HttpServletResponse response){
      User deleteUser = new User();
      deleteUser.setId(id);
      boolean delited = userService.delete(deleteUser);
      if(delited) {
          response.setStatus(200);
      } else response.setStatus(404);
    }

    /**
     * @param user  json : {"login":"login","password":"login"}
     * @param id
     * @param result
     * @param response
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public @ResponseBody User updateUser(@RequestBody @Valid User user, @PathVariable long id, BindingResult result, HttpServletResponse response){
        if(result.hasErrors()){
            return validService.validUser(user, result);
        }
        user.setId(id);
       boolean updated = userService.update(user);
       if(updated){
           response.setStatus(200);
           return  user;
       } else {
           response.setStatus(404);
           return  user;
       }


    }


}
