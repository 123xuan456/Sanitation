package com.reeching.sanitation.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by 绍轩 on 2018/1/3.
 * 此类用来监听webview在fragment中的返回按钮
 */

public abstract class BackHandledFragment extends Fragment{
    protected BackHandledInterface backHandledInterface;

    public abstract boolean onBackPressed();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof BackHandledInterface)){
            throw  new ClassCastException("Not");
        }else {
            this.backHandledInterface= (BackHandledInterface) getActivity();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        //告诉FragmentActivit当前Fragment在栈顶
        backHandledInterface.setSelectFragment(this);

    }

    public interface BackHandledInterface{
        void setSelectFragment(BackHandledFragment backHandledFragment);
    }

}
