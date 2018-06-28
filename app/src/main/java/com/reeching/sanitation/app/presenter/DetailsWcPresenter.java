package com.reeching.sanitation.app.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.app.base.RxPresenter;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.WcDetailBean;
import com.reeching.sanitation.app.contract.DetailsWcContract;
import com.reeching.sanitation.app.util.JsonCallback;

import javax.inject.Inject;

import static com.reeching.sanitation.app.contant.Contants.SAVECHECKTOILET;
import static com.reeching.sanitation.app.contant.Contants.TOILETDETAIL;

/**
 * Created by 绍轩 on 2017/12/14.
 */

public class DetailsWcPresenter extends RxPresenter<DetailsWcContract.View> implements DetailsWcContract.Presenter<DetailsWcContract.View> {


    @Inject
    public DetailsWcPresenter() {
    }

    @Override
    public void getWcDetails(String id) {
        OkGo.<WcDetailBean>post(TOILETDETAIL).tag(this)
                .params("id", id)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new JsonCallback<WcDetailBean>(WcDetailBean.class) {
                    @Override
                    public void onSuccess(Response<WcDetailBean> response) {
                        mView.showWcDetail(response.body());
                    }
                    @Override
                    public void onCacheSuccess(Response<WcDetailBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }
                });

    }

    @Override
    public void getApprove(String id, String userId) {
        OkGo.<JsonBean>post(SAVECHECKTOILET).tag(this)
                .params("id", id)
                .params("userId", userId)
                .params("auditStatus", 3)
                .params("auditReason", "")
                .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                    @Override
                    public void onSuccess(Response<JsonBean> response) {
                        JsonBean jsonBean=response.body();
                        String res = jsonBean.getResult();
                        mView.showApprove(res);
                    }

                    @Override
                    public void onError(Response<JsonBean> response) {
                        super.onError(response);

                    }
                });



    }

    @Override
    public void getAuditFailure(String id, String userId,String auditReason) {
        OkGo.<JsonBean>post(SAVECHECKTOILET).tag(this)
                .params("id", id)
                .params("userId", userId)
                .params("auditStatus", 2)
                .params("auditReason", auditReason)
                .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                    @Override
                    public void onSuccess(Response<JsonBean> response) {
                        JsonBean jsonBean=response.body();
                        String res = jsonBean.getResult();
                        mView.showAuditFailure(res);
                    }
                    @Override
                    public void onError(Response<JsonBean> response) {
                        super.onError(response);

                    }
                });
    }
}
