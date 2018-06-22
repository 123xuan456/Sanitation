package com.reeching.sanitation.app.adapter;

import android.content.Context;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.CaseReplyListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

/**
 * Created by 绍轩 on 2018/3/3.
 */

public class PaymentdetailsListRecycleAdapter extends CommonBaseRecycleAdapter<CaseReplyListBean.InfosBean> {
    public PaymentdetailsListRecycleAdapter(Context context, List<CaseReplyListBean.InfosBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, CaseReplyListBean.InfosBean data, int position) {
        holder.setText(R.id.et,data.getReplyContent());
        holder.setText(R.id.button7,data.getName()+"回复：");
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_paymentdetails;
    }
}
