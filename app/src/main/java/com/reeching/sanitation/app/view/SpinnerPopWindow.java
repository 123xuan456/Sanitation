package com.reeching.sanitation.app.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.adapter.SpinnerFindBaseIdRecycleAdapter;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.util.JsonCallback;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.FINDBASEID;

/**
 * Created by 绍轩 on 2018/3/19.
 * 自定义spinner
 */

public class SpinnerPopWindow <T> extends PopupWindow implements SwipeRefreshLayout.OnRefreshListener{
    private LayoutInflater inflater;
    private RecyclerView recyclerView;
    private List<FindBaseIdBean.InfosBean> list;
    Context context;
    private SpinnerFindBaseIdRecycleAdapter spAdapter;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private int con=1;
    private String objectTypeId;

    public SpinnerPopWindow(Context context,String objectTypeId, List<FindBaseIdBean.InfosBean> list, OnItemClickListener<FindBaseIdBean.InfosBean> clickListener) {
        super(context);
        inflater=LayoutInflater.from(context);
        this.list=list;
        this.context=context;
        this.objectTypeId=objectTypeId;
        init(clickListener);
    }

    private void init(OnItemClickListener<FindBaseIdBean.InfosBean> clickListener){
        View view = inflater.inflate(R.layout.spiner_window_layout, null);
        setContentView(view);
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        spAdapter = new SpinnerFindBaseIdRecycleAdapter(context, null,true);
        recyclerView.setAdapter(spAdapter);
        spAdapter.setOnItemClickListener(clickListener);
    }


    public void setNewData(List<FindBaseIdBean.InfosBean> list) {
        spAdapter.setNewData(list);
    }


    @Override
    public void onRefresh() {
        con++;
        setData(con,objectTypeId);
        mSwipeRefreshWidget.setRefreshing(false);
    }
    private void setData(int i,String objectTypeId){
        OkGo.<FindBaseIdBean>post(FINDBASEID).tag(this)
                .params("objectTypeId", objectTypeId)
                .params("pageSize", 100)
                .params("pageNo", i)
                .execute(new JsonCallback<FindBaseIdBean>(FindBaseIdBean.class) {
                    @Override
                    public void onSuccess(Response<FindBaseIdBean> response) {
                        FindBaseIdBean findBaseIdBean = response.body();
                        if (findBaseIdBean.getResult().equals("1")) {
                            List<FindBaseIdBean.InfosBean> info = findBaseIdBean.getInfos();
                            spAdapter.setLoadMoreData(info);
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();

                    }
                });
    }


}
