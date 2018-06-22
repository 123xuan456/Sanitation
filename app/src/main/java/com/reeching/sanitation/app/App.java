package com.reeching.sanitation.app;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.lzy.okgo.OkGo;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.reeching.sanitation.app.component.AppComponent;
import com.reeching.sanitation.app.component.DaggerAppComponent;
import com.reeching.sanitation.app.module.AppModule;
import com.reeching.sanitation.app.util.CrashHandler;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;

/**
 * Created by 绍轩 on 2017/12/13.
 */

public class App extends Application {

    private static App sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
        SDKInitializer.initialize(this);//百度地图api
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
        OkGo.getInstance().init(this);
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(sInstance));
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
        initCompoent();
    }
    public static App getsInstance() {
        return sInstance;
    }
    private void initCompoent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
