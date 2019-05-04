package hue.edu.xiong.volunteer_travel.controller;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 保存文件, 目前只实现了保存第一个
     */
    @ResponseBody
    @RequestMapping("/savePic")
    public Result savePic(MultipartFile[] files) {
        return pictureService.save(files[0]);
    }

    /**
     * 删除文件
     */
    @ResponseBody
    @RequestMapping("/delPic")
    public Result delPic(String fileId) {
        return ResultGenerator.genSuccessResult();
    }
}













