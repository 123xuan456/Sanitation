package com.reeching.sanitation.app.adapter;

import android.app.Activity;

import com.reeching.sanitation.R;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.MI_ASSESS;

/**
 *  * 监督检查考核平台---业务监察科(挂账案件)
 */
public class Mi_BasCaseRecycleAdapter extends CommonBaseRecycleAdapter<String> {
    private Activity context;
    private int assess;//用来判断考核平台

    public Mi_BasCaseRecycleAdapter(Activity context, List<String> datas, boolean isLoadMore, int assess) {
        super(context, datas, isLoadMore);
        this.context=context;
        this.assess=assess;
    }

    @Override
    protected void convert(ViewHolder holder, final String data, int position) {
        holder.setText(R.id.item_title, data);
//        holder.setOnClickListener(R.id.item_btn, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext, "我是" + data + "的button", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    @Override
    protected int getItemLayoutId() {
        if (assess==MI_ASSESS){
            return R.layout.item_mi_layout;
        }else
        return  R.layout.item_mb_layout;
    }
}
