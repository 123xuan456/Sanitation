package com.reeching.sanitation.app.adapter;

import android.content.Context;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.CaseProcessListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 * Created by 绍轩 on 2018/3/3.
 */

public class PaymentdetailsPRecycleAdapter extends CommonBaseRecycleAdapter<CaseProcessListBean.InfosBean> {
    public PaymentdetailsPRecycleAdapter(Context context, List<CaseProcessListBean.InfosBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, CaseProcessListBean.InfosBean data, int position) {
        holder.setText(R.id.tv_p,data.getDealUserName());
        holder.setText(R.id.tv_flow,data.getProcess());
        holder.setText(R.id.tv_date,data.getCreateDate());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_payment_p;
    }
}
