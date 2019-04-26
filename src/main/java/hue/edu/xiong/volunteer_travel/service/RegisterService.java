package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.User;
import hue.edu.xiong.volunteer_travel.repository.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public Result login(User user, HttpServletResponse response) {
        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (user.getUsername().equals(userByUsername.getUsername())) {
            return ResultGenerator.genFailResult("用户名已被注册");
        }
        if (user.getPassword()==null)
            return ResultGenerator.genFailResult("密码不能为空");

                return ResultGenerator.genFailResult("注册失败");
        }
}

