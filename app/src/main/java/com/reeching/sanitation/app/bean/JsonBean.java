package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/2/23.
 */

public class JsonBean implements Serializable {

    /**
     * result : 1
     * msg : 删除成功
     */

    private String result;
    private String msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
