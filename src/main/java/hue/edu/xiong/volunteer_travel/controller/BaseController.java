package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.model.vo.MenuVo;
import hue.edu.xiong.volunteer_travel.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 一些抽取出来的, 复用的场景
 *
 * @author : orange
 * @date : 2019/4/29
 */
@Controller
public class BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    @ResponseBody
    public List<MenuVo> menu() {
        return menuService.getMenus();
    }

}














