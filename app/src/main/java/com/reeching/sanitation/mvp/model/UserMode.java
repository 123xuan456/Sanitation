package com.reeching.sanitation.mvp.model;

/**
 * Created by 绍轩 on 2017/12/11.
 */

public class UserMode implements IUser {
    String name;
    String passwd;

    public UserMode(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (name==null||passwd==null){
            return -1;
        }
        return 0;
    }
}
