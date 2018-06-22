package com.reeching.sanitation.app.component;

import android.content.Context;

import com.reeching.sanitation.app.module.AppModule;

import dagger.Component;

/**
 * Created by 绍轩 on 2018/3/7.
 */
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getContext();

}
