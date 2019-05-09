package hue.edu.xiong.volunteer_travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/imagesUI")
    public String imagesUI(){
        return "skip/index-mednews-images-detail.html";
    }

    @RequestMapping("/images")
    public String images(Model model) {
        return "skip/index-mednews-images-detail.html";
    }

    @RequestMapping("/innUI")
    public String innUI(){
        return "skip/index-inn-article-detail.html";
    }

    @RequestMapping("/inn")
    public String inn(Model model) {
        return "skip/index-inn-article-detail.html";
    }


}
