package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SkipController {
    @RequestMapping("/articleUI")
    public String articleUI(){
        return "skip/index-mednews-article-detail.html";
    }

    @RequestMapping("/article")
    public String article(Model model) {
        return "login/index-mednews-article-detail.html";
    }

//    @RequestMapping("/article")
//    public String article(User user, HttpServletResponse response) {
//        return "login/index-mednews-article-detail.html";
//    }

    @RequestMapping("/imagesUI")
    public String imagesUI(){
        return "skip/index-mednews-article-detail.html";
    }

    @RequestMapping("/images")
    public String images(Model model) {
        return "login/index-mednews-article-detail.html";
    }



}
