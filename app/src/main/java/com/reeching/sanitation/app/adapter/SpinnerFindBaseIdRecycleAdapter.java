package com.reeching.sanitation.app.adapter;

import android.content.Context;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 * Created by 绍轩 on 2017/12/13.
 * 道路
 */

public class SpinnerFindBaseIdRecycleAdapter extends CommonBaseRecycleAdapter<FindBaseIdBean.InfosBean> {
    public SpinnerFindBaseIdRecycleAdapter(Context context, List<FindBaseIdBean.InfosBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, final FindBaseIdBean.InfosBean data, final int position) {
        holder.setText(R.id.tv,data.getObjectKey1());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_spinnerlist;
    }



}
