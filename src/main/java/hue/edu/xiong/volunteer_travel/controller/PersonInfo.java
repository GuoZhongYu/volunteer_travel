package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.model.Inn;
import hue.edu.xiong.volunteer_travel.model.Volunteer;
import hue.edu.xiong.volunteer_travel.service.InnService;
import hue.edu.xiong.volunteer_travel.service.PictureService;
import hue.edu.xiong.volunteer_travel.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.HttpCookie;

/**
 * @author : orange
 * @date : 2019/5/5
 */
@Controller
public class PersonInfo {

    @Autowired
    private InnService innService;

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/personInfo")
    public String personInfo(
            @CookieValue(name = "username") String yonghuming, @CookieValue(name = "type") String type,  Model model) {

        if("inn".equals(type)) {
            Inn inn = innService.findByUsername(yonghuming);
            model.addAttribute("inn", inn);
            model.addAttribute("idCard", pictureService.findById(inn.getIdCard()));
            model.addAttribute("license", pictureService.findById(inn.getLicense()));

            return "info/inn-info";
        } else if ("volunteer".equals(type)) {
            Volunteer volunteer = volunteerService.findByUsername(yonghuming);
            model.addAttribute("volunteer", volunteer);
            model.addAttribute("idCard", pictureService.findById(volunteer.getIdCard()));

            return "info/volunteer-info";
        }
        throw new IllegalArgumentException("总之就是错了");
    }
}










