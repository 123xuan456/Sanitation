package com.reeching.sanitation.app.util;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;

import com.reeching.sanitation.app.activity.two.HomeActivity;

/**
 * Created by 绍轩 on 2018/6/19.
 * 捕获异常，重新启动
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private Context context;

    public CrashHandler(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LogUtils.e(e.toString());
        unException(t,e);
    }

    /**
     * 操作
     *
     * @param thread
     */
    private void unException(Thread thread, Throwable ex) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
//                Toast.makeText(context, "程序出现异常，即将重新启动", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }).start();
        Log.e("Sandy", "uncaughtException, thread: " + thread
                + " name: " + thread.getName() + " id: " + thread.getId() + "exception: "
                + ex);
        String threadName = thread.getName();
        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        restartApp();
    }

    /**
     * 重启应用
     */
    private void restartApp() {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());//再此之前可以做些退出等操作
    }
}
