package com.reeching.sanitation.app.adapter;

import android.content.Context;
import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.StreetListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.DELSTREETT;

/**
 * Created by 绍轩 on 2017/12/13.
 * 道路
 */

public class StreetListRecycleAdapter extends CommonBaseRecycleAdapter<StreetListBean.InfosBean> {
    public StreetListRecycleAdapter(Context context, List<StreetListBean.InfosBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, final StreetListBean.InfosBean data, final int position) {
        holder.setText(R.id.item_title,data.getStreetName());
//        holder.setText(R.id.textView13,data.getAreaType());//类别
        holder.setText(R.id.textView2,data.getStreetStart());//地点
        holder.setText(R.id.textView4,data.getCompanyName());//所属
//        holder.setText(R.id.textView6,data.getCompanyName());//权属单位
        holder.setText(R.id.textView8,data.getUpdateDate());//介入时间
        holder.getView(R.id.textView10).setVisibility(View.GONE);
        holder.getView(R.id.textView13).setVisibility(View.GONE);
        holder.getView(R.id.textView5).setVisibility(View.GONE);
        holder.getView(R.id.textView6).setVisibility(View.GONE);
        View del=holder.getView(R.id.imageView7);
        String roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        if ("基层角色".equals(roleName)){
            del.setVisibility(View.GONE);
        }
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ids = data.getId();
                LogUtils.i("删除"+ids);
                OkGo.<JsonBean>post(DELSTREETT)
                        .params("ids",ids+",")
                        .params("userId", SharedPreferencesUtil.getInstance().getString("userId"))
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean =response.body();
                                String msg= jsonBean.getMsg();
                                String result= jsonBean.getResult();
                                if ("1".equals(result)){
                                    //删除
                                    remove(position);
                                }
                            }
                        });


            }
        });
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_ins_layout;
    }



}
