package hue.edu.xiong.volunteer_travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : orange
 * @date : 2019/5/5
 */
@Controller
public class ThirdPartyController {

    @RequestMapping("/services")
    public String services(HttpServletRequest request) {
//        String type = null;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("type")) {
//                    type = cookie.getValue();
//                }
//            }
//        }
//        if ("inn".equals(type)) {
//            return "third-party/inn";
//
//        } else if ("volunteer".equals(type)) {
//
//            return "third-party/volunteer";
//        }
        return "third-party/volunteer";
    }

}
