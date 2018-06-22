package com.reeching.sanitation.app.adapter;

import android.content.Context;
import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.ToiletListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.base.CommonBaseRecycleAdapter;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.DELENVIRTOILETT;

/**
 * Created by 绍轩 on 2017/12/13.
 * 公厕
 */

public class ToiletListRecycleAdapter extends CommonBaseRecycleAdapter<ToiletListBean.InfosBean> {
    Context context;
    List<ToiletListBean.InfosBean> datas;
    boolean isChannel;
    public ToiletListRecycleAdapter(Context context, List<ToiletListBean.InfosBean> datas, boolean isOpenLoadMore,boolean isChannel) {
        super(context, datas, isOpenLoadMore);
        this.context=context;
        this.datas=datas;
        this.isChannel=isChannel;
    }


    @Override
    protected void convert(ViewHolder holder, final ToiletListBean.InfosBean data, final int position) {
        holder.setText(R.id.item_title,data.getName());
        holder.setText(R.id.textView2,data.getBelongArea());//区域
        holder.setText(R.id.textView4,data.getTioletTypeName());//类别
        holder.setText(R.id.textView8,data.getBelongStreetName());//街乡

        View del=holder.getView(R.id.imageView7);
        if (isChannel){
            del.setVisibility(View.GONE);
        }
        String roleName = SharedPreferencesUtil.getInstance().getString("roleName");
        if ("基层角色".equals(roleName)){
            del.setVisibility(View.GONE);
        }
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ids = data.getId();
                LogUtils.i("删除"+ids);
                OkGo.<JsonBean>post(DELENVIRTOILETT)
                        .params("ids",ids+",")
                        .params("userId", SharedPreferencesUtil.getInstance().getString("userId"))//暂时使用假数据
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
                                ToastUtil.showToast(context,msg);
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
