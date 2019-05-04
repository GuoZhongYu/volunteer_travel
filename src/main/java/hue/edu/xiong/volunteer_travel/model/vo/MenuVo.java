package hue.edu.xiong.volunteer_travel.model.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author : orange
 * @date : 2019/4/29
 */
@Data
public class MenuVo {
    private String name;
    private String path;

    public MenuVo(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
