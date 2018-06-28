package com.reeching.sanitation.app.activity.two;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.activity.AddWasteActivity;
import com.reeching.sanitation.app.activity.DetailsWasteActivity;
import com.reeching.sanitation.app.adapter.WillRubbishListRecycleAdapter;
import com.reeching.sanitation.app.bean.RubbishListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnLoadMoreListener;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.reeching.sanitation.app.contant.Contants.GETRUBBISHLIST;
import static com.reeching.sanitation.app.util.ActivityUtil.openAct;

/**
 * 垃圾楼管理
 */
public class WasteActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private WillRubbishListRecycleAdapter mAdapter;
    private int pageIndex=1;
    private TextView topName;
    private ImageView topFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wc);
        initView();
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new WillRubbishListRecycleAdapter(this,null,true,false);
        mAdapter.setLoadingView(R.layout.load_loading_layout);
        //加载失败，更新footer view提示
        mAdapter.setLoadFailedView(R.layout.load_failed_layout);
        //加载完成，更新footer view提示
        mAdapter.setLoadEndView(R.layout.load_end_layout);
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                //加载更多
                loadMore();
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener<RubbishListBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, RubbishListBean.InfosBean data, int position) {

                Map<String,Object> params=new HashMap<>();
                params.put("id",data.getId());
                openAct(WasteActivity.this,DetailsWasteActivity.class,params);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        openAct(WasteActivity.this, AddWasteActivity.class);

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        setData(pageIndex);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setData(1);
    }
    private void initView() {
        topName=findViewById(R.id.top_name);
        topFinish=findViewById(R.id.top_finish);
        topName.setText("垃圾楼");
        mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        topFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadMore() {
        pageIndex++;
        setData(pageIndex);
    }

    @Override
    public void onRefresh() {
        //重置数据
        mAdapter.reset();
        if (pageIndex>1){
            pageIndex=1;
        }
        setData(pageIndex);
        mSwipeRefreshWidget.setRefreshing(false);



    }

    public void setData(final int pageIndex) {
        OkGo.<RubbishListBean>post(GETRUBBISHLIST).tag(this)
                .params("pageNo",pageIndex)
                .params("pageSize",20)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
//                .params("auditStatus",3)
                .execute(new JsonCallback<RubbishListBean>(RubbishListBean.class) {

                    @Override
                    public void onStart(Request<RubbishListBean, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<RubbishListBean> response) {
                        RubbishListBean RubbishListBean = response.body();
                        LogUtils.i(RubbishListBean.getResult());
                        if("1".equals(RubbishListBean.getResult())){
                            List<RubbishListBean.InfosBean> data = RubbishListBean.getInfos();
                            LogUtils.i(data.toString());
                            if (pageIndex==1){
                                mAdapter.setNewData(data);
                            }else {
                                mAdapter.setLoadMoreData(data);
                            }

                        }else
                            mAdapter.loadEnd();//加载完成

                    }

                    @Override
                    public void onCacheSuccess(Response<RubbishListBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }

                    @Override
                    public void onError(Response<RubbishListBean> response) {
                        super.onError(response);
                    }
                });
    }
}
