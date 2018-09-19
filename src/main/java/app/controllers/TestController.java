package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class TestController {

@RequestMapping(value = "/info/")
    public @ResponseBody String getVersionProgramm(HttpServletResponse response){
        response.setStatus(200);
        return "version is 1.0";
    }
}
