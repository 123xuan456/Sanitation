package com.reeching.sanitation.app.base;

/**
 * Created by 绍轩 on 2018/3/7.
 */

public interface BaseContract {

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {
        //完成
        void complete();

        void start();

    }
}
