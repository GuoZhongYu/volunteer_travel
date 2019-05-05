package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.User;
import hue.edu.xiong.volunteer_travel.repository.UserRepository;
import hue.edu.xiong.volunteer_travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Xiong YuSong
 * @Date 2019/4/19
 */
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public Result login(User user, HttpServletResponse response) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (userByUsername == null) {
            return ResultGenerator.genFailResult("用户名错误!");
        } else {
            if (user.getPassword().equals(userByUsername.getPassword())) {
                saveInCookie(userByUsername, response);
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("密码错误!");
            }
        }
    }

    /**
     * 登出
     */
    public void logout(User user, HttpServletResponse response) {
        saveInCookie(user, 0, response);
    }

    /**
     * 注册用户信息, 并且保存到cookie
     */
    public Result save(User user, HttpServletResponse response) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (userByUsername != null) {
            return ResultGenerator.genFailResult("用户已存在!");
        }

        user.setId(IdGenerator.id());
        userRepository.saveAndFlush(user);

        saveInCookie(user, response);
        return ResultGenerator.genSuccessResult();
    }

    protected void saveInCookie(User user, HttpServletResponse response) {
        saveInCookie(user, 3600, response);
    }

    protected void saveInCookie(User user, int time, HttpServletResponse response) {
        Cookie username = new Cookie("username", user.getUsername());
        username.setPath("/");
        username.setMaxAge(time);
        response.addCookie(username);

        Cookie type = new Cookie("type", user.getType());
        type.setPath("/");
        type.setMaxAge(time);
        response.addCookie(type);
    }
}
