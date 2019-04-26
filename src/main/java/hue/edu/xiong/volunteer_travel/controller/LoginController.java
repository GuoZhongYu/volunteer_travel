package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.User;
import hue.edu.xiong.volunteer_travel.service.LoginService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author Xiong YuSong
 * @Date 2019/4/10
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    private Object document;

    @RequestMapping("/loginUI")
    public String loginUI() {
        return "login/index-login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(Model model, User user , HttpServletResponse response) {
        return loginService.login(user,response);
    }

    @RequestMapping("/registerUI")
    public String registerUI() {
        return "login/index-register";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        return "login/index-login";
    }

    @RequestMapping("/logout")
    public String logout(User user, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", user.getUsername());
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "index";
    }

}
