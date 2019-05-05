package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.User;
import hue.edu.xiong.volunteer_travel.model.Volunteer;
import hue.edu.xiong.volunteer_travel.repository.VolunteerRepository;
import hue.edu.xiong.volunteer_travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Service
public class VolunteerService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private VolunteerRepository volunteerRepository;

    public Result saveVol(Volunteer volunteer, HttpServletResponse response) {
        Result result = loginService.save(
                new User(IdGenerator.id(), volunteer.getUsername(), volunteer.getPassword(), "volunteer"), response);
        if (result.getCode() == 200) {
            volunteer.setId(IdGenerator.id());
            if(volunteer.getIdCard() == null) {
                volunteer.setIdCard("");
            }
            volunteerRepository.save(volunteer);
        }
        return result;
    }

    public Volunteer findByUsername(String username) {
        return volunteerRepository.findByUsername(username);
    }
}
