package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.model.Inn;
import hue.edu.xiong.volunteer_travel.repository.InnRepository;
import hue.edu.xiong.volunteer_travel.repository.PictureRepository;
import hue.edu.xiong.volunteer_travel.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Service
public class InnService {

    @Autowired
    private InnRepository innRepository;

    public Result innSave(Inn inn) {
        inn.setId(IdGenerator.id());
        innRepository.save(inn);
        return ResultGenerator.genSuccessResult();
    }



}
