package com.reeching.sanitation.app.base;

import android.app.Activity;
import android.os.Bundle;

import com.bigkoo.pickerview.TimePickerView;
import com.reeching.sanitation.app.App;
import com.reeching.sanitation.app.component.AppComponent;

import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;

/**
 * Created by 绍轩 on 2018/3/7.
 */

public abstract class BaseAddActivity extends Activity {
    private TimePickerView pvTime;//时间选择器
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupActivityComponent(App.getsInstance().getAppComponent());
        configViews();
        initDatas();
        initPicture();
    }

    public abstract int getLayoutId() ;
    protected abstract void setupActivityComponent(AppComponent appComponent) ;

    public abstract void initDatas();
    public abstract void configViews();
    public abstract void initPicture();



    public TimePickerView getTime() {
        if (pvTime == null) {
             pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
            //设置标题
            pvTime.setTitle("选择日期");
            //控制时间范围
            Calendar calendar = Calendar.getInstance();
            pvTime.setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR));
            pvTime.setTime(new Date());
            //设置是否循环
            pvTime.setCyclic(false);
            //设置是否可以关闭
            pvTime.setCancelable(true);
        }
        return pvTime;
    }
    public void showTime(){
        getTime().show();
    }


    public void dismissTime(){
        if (pvTime != null) {
            pvTime.dismiss();
            pvTime=null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        dismissTime();
    }
}
