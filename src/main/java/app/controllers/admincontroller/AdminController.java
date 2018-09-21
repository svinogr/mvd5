package app.controllers.admincontroller;


import app.entity.users.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/admin" )
public class AdminController {
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public @ResponseBody  List<UserInfo> getAllUserInfo(HttpServletResponse response){
        List<UserInfo> list = new ArrayList<>();
        UserInfo info = new UserInfo();
        list.add(info);
        return list;
    }
}
