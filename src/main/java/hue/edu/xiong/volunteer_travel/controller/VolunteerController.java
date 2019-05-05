package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.Volunteer;
import hue.edu.xiong.volunteer_travel.service.LoginService;
import hue.edu.xiong.volunteer_travel.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Controller
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @ResponseBody
    @RequestMapping("/saveVol")
    public Result saveVol(Volunteer volunteer, HttpServletResponse response) {
        return volunteerService.saveVol(volunteer, response);
    }

    @RequestMapping("/volunteerForum")
    public String volunteerForum() {
        return "forum/forum";
    }


}










