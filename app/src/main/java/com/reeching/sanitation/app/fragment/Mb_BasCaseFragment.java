package com.reeching.sanitation.app.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.activity.two.PaymentdetailsActivity;
import com.reeching.sanitation.app.adapter.Mb_BasCaseRecycleAdapter;
import com.reeching.sanitation.app.bean.BaseUnitPageCountBean;
import com.reeching.sanitation.app.bean.BillCaseBean;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.recyclerviewadapter.ViewHolder;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemClickListener;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnItemLongClickListener;
import com.reeching.sanitation.app.recyclerviewadapter.interfaces.OnLoadMoreListener;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;
import com.reeching.sanitation.app.util.SharedPreferencesUtil;
import com.reeching.sanitation.app.util.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.reeching.sanitation.app.contant.Contants.BASEUNITPAGECOUNT;
import static com.reeching.sanitation.app.contant.Contants.BILLCASELIST;
import static com.reeching.sanitation.app.contant.Contants.CASEBILLSELECTS;
import static com.reeching.sanitation.app.contant.Contants.DELSELECTS;
import static com.reeching.sanitation.app.contant.Contants.MB_GRIDS;
import static com.reeching.sanitation.app.contant.Contants.MB_GUAZ;
import static com.reeching.sanitation.app.contant.Contants.REVOKECASE;
import static com.reeching.sanitation.app.util.ActivityUtil.openAct;


/**
 * 监督检查考核平台---基层单位功能(网格案件，挂账案件)
 */
public class Mb_BasCaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    TextView topUntreated;
    TextView topRanking;
    TextView topCase;
    private int mType;
    private RecyclerView mRecyclerView;
    private Mb_BasCaseRecycleAdapter mAdapter;
    private Activity context;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private LinearLayoutManager mLayoutManager;
    private int pageIndex = 1;
    private String caseGridId;

    public static Fragment newInstance(int mbGrids) {
        Bundle args = new Bundle();
        Mb_BasCaseFragment fragment = new Mb_BasCaseFragment();
        args.putInt("type", mbGrids);
        fragment.setArguments(args);
        return fragment;
    }

    public Mb_BasCaseFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.context = getActivity();
        View view;
        view = inflater.inflate(R.layout.fragment_mb_basics_case, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        topCase = (TextView) view.findViewById(R.id.top_case);
        topUntreated = (TextView) view.findViewById(R.id.top_untreated);
        initData();
        setTap();
        return view;
    }

    private void initData() {
        //初始化adapter
        mAdapter = new Mb_BasCaseRecycleAdapter(context, null, true);
        //初始化 开始加载更多的loading View
        mAdapter.setLoadingView(R.layout.load_loading_layout);
        //加载失败，更新footer view提示
        mAdapter.setLoadFailedView(R.layout.load_failed_layout);
        //加载完成，更新footer view提示
        mAdapter.setLoadEndView(R.layout.load_end_layout);
        //设置加载更多触发的事件监听
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                loadMore();
            }
        });

        //设置item点击事件监听
        mAdapter.setOnItemClickListener(new OnItemClickListener<BillCaseBean.InfosBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, BillCaseBean.InfosBean data, int position) {
//                if (mType == MB_GRIDS) {
//                    openAct(context, CaseProcessingActivity.class);
//                } else {
                    Map<String, Object> param = new HashMap<>();
                    param.put("caseGridId", data.getId());
                    openAct(context, PaymentdetailsActivity.class, param);
//                }
            }
        });
        mAdapter.setOnItemLongClickListener(new OnItemLongClickListener<BillCaseBean.InfosBean>() {
            @Override
            public void onItemLongClick(ViewHolder viewHolder, BillCaseBean.InfosBean data, int position) {
//                ToastUtil.showToast(getContext(),"长按="+data.getWorkTypeName());
                caseGridId=data.getId();
                String gaiPai = data.getGaipai();
                if (mType == MB_GRIDS) {
                    showListDialog(gaiPai);
                }
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        setData(pageIndex, mType);
    }

    private void showListDialog(String g) {

        final String[] items = {"案件挂账","案件撤销","案件删除" };
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(getContext());
//        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        operation(1);
                        break;
                    case 1:
                        operation(2);
                        break;
                    case 2:
                        operation(3);
                        break;

                }
                // which 下标从0开始
                // ...To-do
            }
        });
        listDialog.show();


    }
    private void operation(int i) {
        switch (i){
            case 1:
                OkGo.<JsonBean>post(CASEBILLSELECTS).params("ids",caseGridId+",")
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean=response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                }
                                ToastUtil.showToast(getActivity(),jsonBean.getMsg());
                            }
                        });
                break;
            case 2:
                OkGo.<JsonBean>post(REVOKECASE).params("ids",caseGridId+",")
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean=response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                }
                                ToastUtil.showToast(getActivity(),jsonBean.getMsg());
                            }
                        });
                break;
            case 3:
                OkGo.<JsonBean>post(DELSELECTS).params("ids",caseGridId+",")
                        .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                            @Override
                            public void onSuccess(Response<JsonBean> response) {
                                JsonBean jsonBean=response.body();
                                if ("1".equals(jsonBean.getResult())) {
                                }
                                ToastUtil.showToast(getActivity(),jsonBean.getMsg());
                            }
                        });
                break;

        }
        setData(pageIndex, mType);

    }
    private void loadMore() {
        pageIndex++;
        setData(pageIndex, mType);

    }

    private void setData(final int pageIndex, int mType) {

        switch (mType) {
            //网格案件
            case MB_GRIDS:
                OkGo.<BillCaseBean>post(BILLCASELIST).tag(this)
                        .params("userId", SharedPreferencesUtil.getInstance().getString("userId"))
                        .params("pageNo", pageIndex)
                        .params("pageSize", 20)
                        .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                        .execute(new JsonCallback<BillCaseBean>(BillCaseBean.class) {
                            @Override
                            public void onSuccess(Response<BillCaseBean> response) {
                                BillCaseBean toiletListBean = response.body();
                                LogUtils.i(toiletListBean.getResult());
                                if ("1".equals(toiletListBean.getResult())) {
                                    List<BillCaseBean.InfosBean> data = toiletListBean.getInfos();
                                    LogUtils.i(data.toString());
                                    if (pageIndex == 1) {
                                        mAdapter.setNewData(data);
                                    } else {
                                        mAdapter.setLoadMoreData(data);
                                    }
                                } else {
                                    mAdapter.loadEnd();//加载完成
                                }

                            }

                            @Override
                            public void onError(Response<BillCaseBean> response) {
                                super.onError(response);
                                ToastUtil.showToast(getContext(), "网络错误");
                            }

                            @Override
                            public void onCacheSuccess(Response<BillCaseBean> response) {
                                super.onCacheSuccess(response);
                                onSuccess(response);
                            }
                        });


                break;
            //挂账案件
            case MB_GUAZ:
                OkGo.<BillCaseBean>post(BILLCASELIST).tag(this)
                        .params("pageNo", pageIndex)
                        .params("pageSize", 20)
                        .params("userId", SharedPreferencesUtil.getInstance().getString("userId"))
                        .params("isBill", 1)
                        .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                        .execute(new JsonCallback<BillCaseBean>(BillCaseBean.class) {
                            @Override
                            public void onSuccess(Response<BillCaseBean> response) {
                                BillCaseBean toiletListBean = response.body();
                                LogUtils.i(toiletListBean.getResult());
                                if ("1".equals(toiletListBean.getResult())) {
                                    List<BillCaseBean.InfosBean> data = toiletListBean.getInfos();
                                    LogUtils.i(data.toString());
                                    if (pageIndex == 1) {
                                        mAdapter.setNewData(data);
                                    } else {
                                        mAdapter.setLoadMoreData(data);
                                    }
                                } else {
                                    mAdapter.loadEnd();//加载完成
                                }

                            }
                            @Override
                            public void onCacheSuccess(Response<BillCaseBean> response) {
                                super.onCacheSuccess(response);
                                onSuccess(response);
                            }
                            @Override
                            public void onError(Response<BillCaseBean> response) {
                                super.onError(response);
                                ToastUtil.showToast(getContext(), "网络错误");
                            }
                        });


                break;
        }

    }

    public void setTap() {
        OkGo.<BaseUnitPageCountBean>post(BASEUNITPAGECOUNT).tag(this)
                .params("userId", SharedPreferencesUtil.getInstance().getString("userId"))
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new JsonCallback<BaseUnitPageCountBean>(BaseUnitPageCountBean.class) {
                    @Override
                    public void onSuccess(Response<BaseUnitPageCountBean> response) {
                        BaseUnitPageCountBean baseUnitPageCountBean = response.body();
                        if (baseUnitPageCountBean.getResult().equals("1")) {
                            topCase.setText(baseUnitPageCountBean.getTodayCaseCount() + "");
                            topUntreated.setText(baseUnitPageCountBean.getBillCaseCount() + "");
                        }

                    }

                    @Override
                    public void onCacheSuccess(Response<BaseUnitPageCountBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }
                });
    }

    @Override
    public void onRefresh() {
        mAdapter.reset();
        if (pageIndex > 1) {
            pageIndex = 1;
        }
        setData(pageIndex, mType);
        mSwipeRefreshWidget.setRefreshing(false);


    }
}


