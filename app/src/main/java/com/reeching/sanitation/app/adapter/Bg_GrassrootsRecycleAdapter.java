package com.reeching.sanitation.app.adapter;

import android.app.Activity;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.ToiletListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 * 基础数据平台-基层单位-公厕/待审核数据/最近修改
 */
public class Bg_GrassrootsRecycleAdapter extends CommonBaseRecycleAdapter<ToiletListBean.InfosBean> {
    public Bg_GrassrootsRecycleAdapter(Activity context, List<ToiletListBean.InfosBean> datas, boolean isLoadMore) {
        super(context, datas, isLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, ToiletListBean.InfosBean data, int position) {
        holder.setText(R.id.item_title,data.getName());
        holder.setText(R.id.textView26,data.getTioletType());//类别
        holder.setText(R.id.textView2,data.getAddress());//地点
        holder.setText(R.id.textView4,data.getBelongArea());//所属
        holder.setText(R.id.textView6,data.getFieldTeam());//权属单位
        holder.setText(R.id.textView8,data.getUpdateDate());//介入时间
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_layout;
    }
}
