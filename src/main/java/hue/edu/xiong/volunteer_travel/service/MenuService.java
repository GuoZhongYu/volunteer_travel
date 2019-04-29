package hue.edu.xiong.volunteer_travel.service;

import hue.edu.xiong.volunteer_travel.model.enums.Authority;
import hue.edu.xiong.volunteer_travel.model.enums.MenuVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 根据不同的登录信息, 返回不同的菜单结果
 *
 * @author : orange
 * @date : 2019/4/29
 */
@Service
public class MenuService {

    public List<MenuVo> getMenus() {
        Authority[] values = Authority.values();
        List<MenuVo> lists = new ArrayList<>();
        Stream.of(values).forEach((value) -> {
            lists.add(new MenuVo(value.getName(), value.getPath())); });
        return lists;
    }
}
