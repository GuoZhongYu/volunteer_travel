package hue.edu.xiong.volunteer_travel.model.enums;

import lombok.Data;

/**
 * 顶部链接
 *
 * @author : orange
 * @date : 2019/4/29
 */
public enum Authority {

    homePage("首页", "/"),
    innIndexUI("客栈列表", "/innIndexUI"),
    diaryUI("旅行日记", "/diaryUI"),
    volunteerForum("义工论坛", "/volunteerForum"),
    publishInfo("发布信息", "/publishInfo"),
    services("第三方服务", "/services");

    Authority(String name, String path) {
        this.name = name;
        this.path = path;
    }

    String name;
    String path;

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
