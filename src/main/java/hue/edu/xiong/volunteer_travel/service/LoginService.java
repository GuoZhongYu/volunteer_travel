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

                saveInCookie(user, response);
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("密码错误!");
            }
        }
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
        Cookie cookie = new Cookie("username", user.getUsername());
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}
