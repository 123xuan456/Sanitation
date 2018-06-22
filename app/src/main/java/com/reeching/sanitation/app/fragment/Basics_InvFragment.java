package com.reeching.sanitation.app.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.activity.two.Inv_ChannelFragment;

import java.util.ArrayList;
import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.INV_ROAD;
import static com.reeching.sanitation.app.contant.Contants.INV_WASTE;
import static com.reeching.sanitation.app.contant.Contants.INV_WC;

/**
 *基础数据平台- 业务监察科-待审核数据
 */
public class Basics_InvFragment extends Fragment {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    public Basics_InvFragment() {
    }
    public static Fragment newInstance(int basicsInv) {
        Basics_InvFragment f=new Basics_InvFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view ;
        view = inflater.inflate(R.layout.fragment_basics__inv, null);
        mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTablayout.addTab(mTablayout.newTab().setText(R.string.ins_wc));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.ins_road));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.ins_waste));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.ins_people));
        mTablayout.setupWithViewPager(mViewPager);

        return view;
    }
    public void setupViewPager(ViewPager mViewPager) {
        //Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(Inv_ChannelFragment.newInstance(INV_WC), getString(R.string.ins_wc));
        adapter.addFragment(Inv_ChannelFragment.newInstance(INV_ROAD), getString(R.string.ins_road));
        adapter.addFragment(Inv_ChannelFragment.newInstance(INV_WASTE), getString(R.string.ins_waste));
//        adapter.addFragment(Inv_ChannelFragment.newInstance(INV_PEOPLE), getString(R.string.ins_people));
        mViewPager.setAdapter(adapter);
    }
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
