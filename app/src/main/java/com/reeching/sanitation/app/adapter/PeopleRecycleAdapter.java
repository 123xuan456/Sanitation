package com.reeching.sanitation.app.adapter;

import android.content.Context;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.PeopleBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 * Created by 绍轩 on 2017/12/13.
 * 人员
 */

public class PeopleRecycleAdapter extends CommonBaseRecycleAdapter<PeopleBean.InfosBean> {
    Context context;
    List<PeopleBean.InfosBean> datas;

    public PeopleRecycleAdapter(Context context, List<PeopleBean.InfosBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context=context;
        this.datas=datas;
    }


    @Override
    protected void convert(ViewHolder holder, final PeopleBean.InfosBean data, final int position) {
        holder.setText(R.id.tv,data.getName());

    }


    @Override
    protected int getItemLayoutId() {
        return R.layout.item_list;
    }



}
