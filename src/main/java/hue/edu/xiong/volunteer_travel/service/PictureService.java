package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.core.ServiceException;
import hue.edu.xiong.volunteer_travel.model.Picture;
import hue.edu.xiong.volunteer_travel.repository.PictureRepository;
import hue.edu.xiong.volunteer_travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public Result save(MultipartFile file) {
        String name = System.currentTimeMillis() + ".jpg";
        Picture picture = new Picture(IdGenerator.id(), name, file.getOriginalFilename(), savePath(file, name));
        pictureRepository.saveAndFlush(picture);
        return ResultGenerator.genSuccessResult(picture);
    }

    private String savePath(MultipartFile file, String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        // 创建根目录
        File homeDir = new File("E:/picpath/");
        if (!homeDir.exists() || !homeDir.isDirectory()) {
            homeDir.mkdirs();
        }
        // 创建父级目录
        File descFile = new File(homeDir, ymd + File.separator + name);
        if (!descFile.getParentFile().exists()) {
            descFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(descFile);
        } catch (IllegalStateException | IOException e) {
            throw new ServiceException("文件上传失败!");
        }
        return descFile.getPath();
    }


}
