package com.reeching.sanitation.app.adapter;

import android.content.Context;
import android.view.View;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.ToiletListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 * Created by 绍轩 on 2017/12/13.
 * 公厕
 */

public class WillToiletListRecycleAdapter extends CommonBaseRecycleAdapter<ToiletListBean.InfosBean> {
    Context context;
    List<ToiletListBean.InfosBean> datas;

    public WillToiletListRecycleAdapter(Context context, List<ToiletListBean.InfosBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context=context;
        this.datas=datas;
    }


    @Override
    protected void convert(ViewHolder holder, final ToiletListBean.InfosBean data, final int position) {
        holder.setText(R.id.item_title,data.getName());
        holder.setText(R.id.textView13,data.getTioletTypeName());//类别
        holder.setText(R.id.textView2,data.getAddress());//地点
        holder.setText(R.id.textView4,data.getFieldTeamName());//所属
        holder.setText(R.id.textView6,data.getFieldTeamName());//权属单位
        holder.setText(R.id.textView8,data.getCreateDate());//介入时间
        holder.setText(R.id.textView16,data.getUpdateDate());//提交时间
        holder.getView(R.id.textView2).setVisibility(View.GONE);
        holder.getView(R.id.textView).setVisibility(View.GONE);
        holder.getView(R.id.textView6).setVisibility(View.GONE);
        holder.getView(R.id.textView5).setVisibility(View.GONE);
    }


    @Override
    protected int getItemLayoutId() {
        return R.layout.item_inv_layout;
    }



}
