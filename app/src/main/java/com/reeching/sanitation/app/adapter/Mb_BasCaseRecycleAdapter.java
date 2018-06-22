package com.reeching.sanitation.app.adapter;

import android.app.Activity;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.BillCaseBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 *  * 监督检查考核平台---基层单位功能(网格案件，挂账案件)
 */
public class Mb_BasCaseRecycleAdapter extends CommonBaseRecycleAdapter<BillCaseBean.InfosBean> {
    private Activity context;
    public Mb_BasCaseRecycleAdapter(Activity context, List<BillCaseBean.InfosBean> datas, boolean isLoadMore) {
        super(context, datas, isLoadMore);
        this.context=context;
    }


    @Override
    protected void convert(ViewHolder holder, BillCaseBean.InfosBean data, int position) {
        holder.setText(R.id.item_title,data.getFileNumber());
        holder.setText(R.id.textView13,data.getWorkTypeName());//类别
        holder.setText(R.id.textView2,data.getPointName());//点位名称
        holder.setText(R.id.textView4,data.getCaseDesc());//问题描述
        holder.setText(R.id.textView8,data.getCompanyName());//作业公司
        holder.setText(R.id.textView14,data.getCaseDate());//时间
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_mb_layout;
    }
}
