package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.model.Inn;
import hue.edu.xiong.volunteer_travel.service.InnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Xiong YuSong
 * @Date 2019/4/18
 */
@Controller
public class InnController {

    @Autowired
    private InnService innService;

    /**
     * 客栈列表展示
     *
     * @return
     */
    @RequestMapping("/innIndexUI")
    public String index() {
        return "inn/inn-index";
    }

    /**
     * 客栈注册页面
     *
     * @return
     */
    @RequestMapping("/innRegisterUI")
    public String innRegisterUI() {
        return "inn/inn-register";
    }

    /**
     * 客栈添加.保存
     */
    @ResponseBody
    @RequestMapping("/innSave")
    public Result innSave(Inn inn) {
        return innService.innSave(inn);
    }




}
