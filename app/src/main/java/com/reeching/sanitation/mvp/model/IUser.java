package com.reeching.sanitation.mvp.model;

/**
 * Created by 绍轩 on 2017/12/11.
 */

public interface IUser {
    String getName();
    String getPasswd();

    int checkUserValidity(String name, String passwd);
}
