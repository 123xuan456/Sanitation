package com.reeching.sanitation.app.activity.two;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.activity.DetailsRoadActivity;
import com.reeching.sanitation.app.activity.DetailsWasteActivity;
import com.reeching.sanitation.app.activity.DetailsWcActivity;
import com.reeching.sanitation.app.adapter.ToiletListRecycleAdapter;
import com.reeching.sanitation.app.adapter.WillRubbishListRecycleAdapter;
import com.reeching.sanitation.app.adapter.WillStreetListRecycleAdapter;
import com.reeching.sanitation.app.bean.RubbishListBean;
import com.reeching.sanitation.app.bean.StreetListBean;
import com.reeching.sanitation.app.bean.ToiletListBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnLoadMoreListener;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.reeching.sanitation.app.contant.Contants.INV_ROAD;
import static com.reeching.sanitation.app.contant.Contants.INV_WASTE;
import static com.reeching.sanitation.app.contant.Contants.INV_WC;
import static com.reeching.sanitation.app.contant.Contants.WILLSUBMITTEDRUBBISH;
import static com.reeching.sanitation.app.contant.Contants.WILLSUBMITTEDSTREET;
import static com.reeching.sanitation.app.contant.Contants.WILLSUBMITTEDTOILET;
import static com.reeching.sanitation.app.util.ActivityUtil.openAct;

/**
 *  基础数据平台-业务监察科-待审核数据-子页面
 */
public class Inv_ChannelFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private int mType;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
//    private Inv_ChannelAdapter mAdapter;
    private List<ToiletListBean.InfosBean> mData;
    private ToiletListRecycleAdapter mAdapter;//公厕
    private WillStreetListRecycleAdapter mAdapter1;//道路
    private WillRubbishListRecycleAdapter mAdapter2;//垃圾篓
    private int pageIndex=1;

    public static Fragment newInstance(int i) {
        Bundle args = new Bundle();
        Inv_ChannelFragment fragment = new Inv_ChannelFragment();
        args.putInt("type", i);
        fragment.setArguments(args);
        return fragment;
    }

    public Inv_ChannelFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");

        LogUtils.i(mType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inv__channel, null);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ToiletListRecycleAdapter(getActivity(),null,true,true);//公厕
        mAdapter1 = new WillStreetListRecycleAdapter(getActivity(),null,true,true);//道路
        mAdapter2 = new WillRubbishListRecycleAdapter(getActivity(),null,true,true);//垃圾篓
        //初始化 开始加载更多的loading View
        mAdapter.setLoadingView(R.layout.load_loading_layout);
        mAdapter1.setLoadingView(R.layout.load_loading_layout);
        mAdapter2.setLoadingView(R.layout.load_loading_layout);
        //加载失败，更新footer view提示
        mAdapter.setLoadFailedView(R.layout.load_failed_layout);
        mAdapter1.setLoadFailedView(R.layout.load_failed_layout);
        mAdapter2.setLoadFailedView(R.layout.load_failed_layout);
        //加载完成，更新footer view提示
        mAdapter.setLoadEndView(R.layout.load_end_layout);
        mAdapter1.setLoadEndView(R.layout.load_end_layout);
        mAdapter2.setLoadEndView(R.layout.load_end_layout);
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                //加载更多
                loadMore();
            }
        });

        mAdapter1.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                //加载更多
                loadMore();
            }
        });
        mAdapter2.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                //加载更多
                loadMore();
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener<ToiletListBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, ToiletListBean.InfosBean data, int position) {
                Map<String,Object> params=new HashMap<>();
                params.put("type",mType);
                params.put("id",data.getId());
                openAct(getActivity(),DetailsWcActivity.class,params);
            }
        });
        mAdapter1.setOnItemClickListener(new OnItemClickListener<StreetListBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, StreetListBean.InfosBean data, int position) {

                Map<String,Object> params=new HashMap<>();
                params.put("type",mType);
                params.put("id",data.getId());
                openAct(getActivity(),DetailsRoadActivity.class,params);
            }
        });
        mAdapter2.setOnItemClickListener(new OnItemClickListener<RubbishListBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, RubbishListBean.InfosBean data, int position) {

                Map<String,Object> params=new HashMap<>();
                params.put("type",mType);
                params.put("id",data.getId());
                openAct(getActivity(),DetailsWasteActivity.class,params);
            }
        });
        setData(pageIndex,mType);
        return view;

    }

    private void loadMore() {
        pageIndex++;
        setData(pageIndex,mType);
    }

    @Override
    public void onResume() {
        super.onResume();
        setData(pageIndex,mType);
    }

    private void setData(final int pageIndex, int Type) {
        switch (Type){
            case INV_WC:
                mRecyclerView.setAdapter(mAdapter);

                OkGo.<ToiletListBean>post(WILLSUBMITTEDTOILET).tag(this)
                        .params("pageNo",pageIndex)
                        .params("pageSize",20)
                        .params("auditStatus",3)
                        .execute(new JsonCallback<ToiletListBean>(ToiletListBean.class) {
                            @Override
                            public void onSuccess(Response<ToiletListBean> response) {
                                ToiletListBean toiletListBean = response.body();
                                LogUtils.i(toiletListBean.getResult());
                                if("1".equals(toiletListBean.getResult())){
                                    List<ToiletListBean.InfosBean> data = toiletListBean.getInfos();
                                    LogUtils.i(data.toString());
                                    if (pageIndex==1){
                                        mAdapter.setNewData(data);
                                    }else {
                                        mAdapter.setLoadMoreData(data);
                                    }
                                }
                                    mAdapter.loadEnd();//加载完成

                            }

                            @Override
                            public void onError(Response<ToiletListBean> response) {
                                super.onError(response);
                                ToastUtil.showToast(getContext(),"网络错误");
                            }
                        });
                break;

            case INV_ROAD:
                mRecyclerView.setAdapter(mAdapter1);

                OkGo.<StreetListBean>post(WILLSUBMITTEDSTREET).tag(this)
                        .params("pageNo",pageIndex)
                        .params("pageSize",20)
                        .params("auditStatus",3)
                        .execute(new JsonCallback<StreetListBean>(StreetListBean.class) {
                            @Override
                            public void onSuccess(Response<StreetListBean> response) {
                                StreetListBean toiletListBean = response.body();
                                LogUtils.i(toiletListBean.getResult());
                                if("1".equals(toiletListBean.getResult())){
                                    List<StreetListBean.InfosBean> data = toiletListBean.getInfos();
                                    LogUtils.i(data.toString());
                                    if (pageIndex==1){
                                        mAdapter1.setNewData(data);
                                    }else {
                                        mAdapter1.setLoadMoreData(data);
                                    }
                                }
                                mAdapter1.loadEnd();//加载完成


                            }

                            @Override
                            public void onError(Response<StreetListBean> response) {
                                super.onError(response);
                                ToastUtil.showToast(getContext(),"网络错误");
                            }
                        });
                break;
            case INV_WASTE:
                mRecyclerView.setAdapter(mAdapter2);
                OkGo.<RubbishListBean>post(WILLSUBMITTEDRUBBISH).tag(this)
                        .params("pageNo",pageIndex)
                        .params("pageSize",20)
                        .params("auditStatus",3)
                        .execute(new JsonCallback<RubbishListBean>(RubbishListBean.class) {
                            @Override
                            public void onSuccess(Response<RubbishListBean> response) {
                                RubbishListBean toiletListBean = response.body();
                                LogUtils.i(toiletListBean.getResult());
                                if("1".equals(toiletListBean.getResult())){
                                    List<RubbishListBean.InfosBean> data = toiletListBean.getInfos();
                                    LogUtils.i(data.toString());
                                    if (pageIndex==1){
                                        mAdapter2.setNewData(data);
                                    }else {
                                        mAdapter2.setLoadMoreData(data);
                                    }
                                }
                                    mAdapter2.loadEnd();//加载完成

                            }

                            @Override
                            public void onError(Response<RubbishListBean> response) {
                                super.onError(response);
                                ToastUtil.showToast(getContext(),"网络错误");
                            }
                        });
                break;




        }




    }

    @Override
    public void onRefresh() {
        //重置数据
        mAdapter.reset();
        mAdapter1.reset();
        mAdapter2.reset();
        if (pageIndex>1){
            pageIndex=1;
        }
        setData(pageIndex,mType);
        mSwipeRefreshWidget.setRefreshing(false);




    }
}
