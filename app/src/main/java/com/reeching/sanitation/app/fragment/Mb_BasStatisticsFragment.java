package com.reeching.sanitation.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.R;
import com.reeching.sanitation.app.bean.BaseUnitPageCountBean;
import com.reeching.sanitation.app.util.JsonCallback;

import butterknife.ButterKnife;

import static com.reeching.sanitation.app.contant.Contants.BASEUNITCOUNTPAGE;
import static com.reeching.sanitation.app.contant.Contants.BASEUNITPAGECOUNT;
import static com.reeching.sanitation.app.contant.Contants.CASECOUNTPAGE;
import static com.reeching.sanitation.app.contant.Contants.MB_HOME;
import static com.reeching.sanitation.app.contant.Contants.MB_STATISTICS;

/**
 * 监督检查考核平台---基层单位功能(首页，案件统计)
 */
public class Mb_BasStatisticsFragment extends Fragment {
    TextView topUntreated;
    TextView topRanking;
    TextView topCase;
    private int mType;
    private WebView webview;

    public static Fragment newInstance(int mbGrids) {
        Bundle args = new Bundle();
        Mb_BasStatisticsFragment fragment = new Mb_BasStatisticsFragment();
        args.putInt("type", mbGrids);
        fragment.setArguments(args);
        return fragment;
    }

    public Mb_BasStatisticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_mb__basics_statistics, container, false);
        mType = getArguments().getInt("type");
        webview = (WebView) view.findViewById(R.id.web);
        topCase = (TextView) view.findViewById(R.id.top_case);
        topUntreated = (TextView) view.findViewById(R.id.top_untreated);

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        // 设置支持javascript
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        if (mType == MB_HOME) {
            webview.loadUrl(CASECOUNTPAGE);
        } else if (mType == MB_STATISTICS) {
            webview.loadUrl(BASEUNITCOUNTPAGE);
        }
        setTap();


        return view;
    }

    public void setTap() {
        OkGo.<BaseUnitPageCountBean>post(BASEUNITPAGECOUNT).tag(this)
                .params("userId", 1)
                .execute(new JsonCallback<BaseUnitPageCountBean>(BaseUnitPageCountBean.class) {
                    @Override
                    public void onSuccess(Response<BaseUnitPageCountBean> response) {
                        BaseUnitPageCountBean baseUnitPageCountBean = response.body();
                        if (baseUnitPageCountBean.getResult().equals("1")) {
                            topCase.setText(baseUnitPageCountBean.getTodayCaseCount()+"");
                            topUntreated.setText(baseUnitPageCountBean.getBillCaseCount()+"");
                        }

                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
