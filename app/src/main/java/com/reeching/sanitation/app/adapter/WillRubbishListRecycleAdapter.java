package com.reeching.sanitation.app.adapter;

import android.content.Context;
import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.RubbishListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.DELRUBBISHT;

/**
 * Created by 绍轩 on 2017/12/13.
 * 垃圾篓
 */

public class WillRubbishListRecycleAdapter extends CommonBaseRecycleAdapter<RubbishListBean.InfosBean> {
    boolean isChannel;
    public WillRubbishListRecycleAdapter(Context context, List<RubbishListBean.InfosBean> datas, boolean isOpenLoadMore,boolean isChannel) {
        super(context, datas, isOpenLoadMore);
        this.isChannel=isChannel;
    }

    @Override
    protected void convert(ViewHolder holder, final RubbishListBean.InfosBean data, final int position) {
        holder.setText(R.id.item_title,data.getRubbishName());
        holder.setText(R.id.textView2,data.getFieldTeamName());//场对
        holder.setText(R.id.textView4,data.getRubbishNo());//编号
        holder.setText(R.id.textView8,data.getBelongCommunityName());//社区
        holder.setText(R.id.textView16,data.getBelongStreetName());//街乡
        View del=holder.getView(R.id.imageView7);
        String roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        if ("基层角色".equals(roleName)){
            del.setVisibility(View.GONE);
        }
        if (isChannel){
            del.setVisibility(View.GONE);
        }
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ids = data.getId();
                LogUtils.i("删除"+ids);
                OkGo.<JsonBean>post(DELRUBBISHT)
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
        return R.layout.item_rubbish_layout;
    }



}
