package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/3/16.
 */

public class HomeImageBean implements Serializable {
    int id;
    String title;
    int icon;

    public HomeImageBean(int id, String typename, int icon) {
        super();
        this.id = id;
        this.title = typename;
        this.icon = icon;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgUrl() {
        return icon;
    }

    public void setImgUrl(int imgUrl) {
        this.icon = imgUrl;
    }
}
