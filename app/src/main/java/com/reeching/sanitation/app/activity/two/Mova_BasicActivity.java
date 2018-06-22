package com.reeching.sanitation.app.activity.two;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.fragment.Mb_BasCaseFragment;
import com.reeching.sanitation.app.fragment.Mb_BasStatisticsFragment;

import static com.reeching.sanitation.app.contant.Contants.MB_GRIDS;
import static com.reeching.sanitation.app.contant.Contants.MB_GUAZ;
import static com.reeching.sanitation.app.contant.Contants.MB_STATISTICS;

/**
 * 监督检查考核平台--基层单位
 */
public class Mova_BasicActivity extends FragmentActivity implements  RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mova);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);

        if (fragment == null) {
            fragment = Mb_BasCaseFragment.newInstance(MB_GRIDS);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, Mb_BasCaseFragment.newInstance(MB_GRIDS)).commit();
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
//            case R.id.m_basic_home_rd: {
//                fragment = Mb_BasStatisticsFragment.newInstance(MB_HOME);//检查考核平台-基层单位首页
//            }
//            break;
            case R.id.m_basic_grids_rd: {
                fragment = Mb_BasCaseFragment.newInstance(MB_GRIDS);//检查考核平台-基层单位网格案件
            }
            break;
            case R.id.m_basic_guaz_rd: {
                fragment = Mb_BasCaseFragment.newInstance(MB_GUAZ);//检查考核平台-基层单位挂账案件
            }
            break;
            case R.id.m_basic_statistics_rd: {
                fragment = Mb_BasStatisticsFragment.newInstance(MB_STATISTICS);//检查考核平台-基层单位案件统计
            }
            break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
        }
    }
}
