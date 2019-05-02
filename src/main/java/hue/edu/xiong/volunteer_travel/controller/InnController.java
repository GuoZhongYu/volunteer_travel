package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Xiong YuSong
 * @Date 2019/4/18
 */
@Controller
public class InnController {

    /**
     * 客栈列表展示
     * @return
     */
    @RequestMapping("/innIndexUI")
    public String index(){
        return "inn/inn-index";
    }

    /**
     * 客栈注册页面
     * @return
     */
    @RequestMapping("/innRegisterUI")
    public String innRegisterUI(){
        return "inn/inn-register";
    }

    /**
     * 客栈添加.保存
     */
    @ResponseBody
    @RequestMapping("/innSave")
    public Result innSave(){
        return ResultGenerator.genSuccessResult();
    }


}
