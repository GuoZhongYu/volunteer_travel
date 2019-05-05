package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.Inn;
import hue.edu.xiong.volunteer_travel.model.User;
import hue.edu.xiong.volunteer_travel.repository.InnRepository;
import hue.edu.xiong.volunteer_travel.repository.PictureRepository;
import hue.edu.xiong.volunteer_travel.repository.UserRepository;
import hue.edu.xiong.volunteer_travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Service
public class InnService {

    @Autowired
    private InnRepository innRepository;

    @Autowired
    private LoginService loginService;

    /**
     * 我也不知道为什么要调用loginService来处理登录, 并且创建了 user Entity
     */
    public Result innSave(Inn inn, HttpServletResponse response) {
        Result result = loginService.save(new User(IdGenerator.id(), inn.getUsername(), inn.getPassword(), "inn"), response);
        if (result.getCode() == 200) {
            if (inn.getIdCard() == null) {
                inn.setIdCard("");
            } else if (inn.getLicense() == null) {
                inn.setLicense("");
            }
            inn.setId(IdGenerator.id());
            innRepository.save(inn);
        }
        return result;
    }


    public Inn findByUsername(String username) {
        return innRepository.findByUsername(username);
    }
}
