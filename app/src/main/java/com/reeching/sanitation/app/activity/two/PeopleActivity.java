package com.reeching.sanitation.app.activity.two;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.adapter.PeopleRecycleAdapter;
import com.reeching.sanitation.app.bean.PeopleBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.view.RecyclerItemDecoration;

import java.util.List;

import static com.reeching.sanitation.app.contant.Contants.GETUSERLIST;

/**
 * 人员管理
 */
public class PeopleActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private PeopleRecycleAdapter mAdapter;
    private TextView topName;
    private ImageView topFinish;
    private String userId;

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
        mRecyclerView.addItemDecoration(new RecyclerItemDecoration(this,RecyclerItemDecoration.VERTICAL_LIST));
        mAdapter = new PeopleRecycleAdapter(this,null,true);
        mAdapter.setOnItemClickListener(new OnItemClickListener<PeopleBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, PeopleBean.InfosBean data, int position) {
//
//                Map<String,Object> params=new HashMap<>();
//                params.put("id",data.getId());
//                openAct(PeopleActivity.this,DetailsWcActivity.class,params);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        mRecyclerView.setAdapter(mAdapter);
        setData();
    }

    private void initView() {
        userId= SharedPreferencesUtil.getInstance().getString("userId");
        topName=findViewById(R.id.top_name);
        topFinish=findViewById(R.id.top_finish);
        topName.setText("人员");
        mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        topFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onRefresh() {
        //重置数据
        mAdapter.reset();
        setData();
        mSwipeRefreshWidget.setRefreshing(false);

    }

    public void setData() {
        OkGo.<PeopleBean>post(GETUSERLIST).tag(this)
                .params("userId",userId)
                .execute(new JsonCallback<PeopleBean>(PeopleBean.class) {

                    @Override
                    public void onStart(Request<PeopleBean, ? extends Request> request) {
                        super.onStart(request);

                    }

                    @Override
                    public void onSuccess(Response<PeopleBean> response) {
                        PeopleBean PeopleBean = response.body();
                        LogUtils.i(PeopleBean.getResult());
                        if("1".equals(PeopleBean.getResult())){
                            List<PeopleBean.InfosBean> data = PeopleBean.getInfos();
                            mAdapter.setData(data);

                        }else
                            mAdapter.loadEnd();//加载完成

                    }

                    @Override
                    public void onError(Response<PeopleBean> response) {
                        super.onError(response);
                    }
                });
    }
}
