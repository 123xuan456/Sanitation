package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/3/1.
 */

public class BaseUnitPageCountBean implements Serializable {

    /**
     * result : 1
     * msg : 获取成功！
     * todayCaseCount : 0
     * billCaseCount : 20
     */

    private String result;
    private String msg;
    private int todayCaseCount;
    private int billCaseCount;

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

    public int getTodayCaseCount() {
        return todayCaseCount;
    }

    public void setTodayCaseCount(int todayCaseCount) {
        this.todayCaseCount = todayCaseCount;
    }

    public int getBillCaseCount() {
        return billCaseCount;
    }

    public void setBillCaseCount(int billCaseCount) {
        this.billCaseCount = billCaseCount;
    }
}
