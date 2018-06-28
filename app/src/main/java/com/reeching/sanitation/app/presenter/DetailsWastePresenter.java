package com.reeching.sanitation.app.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.app.base.RxPresenter;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.WasteDetailBean;
import com.reeching.sanitation.app.contract.DetailsWasteContract;
import com.reeching.sanitation.app.util.JsonCallback;

import javax.inject.Inject;

import static com.reeching.sanitation.app.contant.Contants.RUBBISHDETAIL;
import static com.reeching.sanitation.app.contant.Contants.SAVECHECKRUBBISH;

/**
 * Created by 绍轩 on 2017/12/14.
 */

public class DetailsWastePresenter extends RxPresenter<DetailsWasteContract.View> implements DetailsWasteContract.Presenter<DetailsWasteContract.View> {


    @Inject
    public DetailsWastePresenter() {
    }

    @Override
    public void getWasteDetails(String id) {
        OkGo.<WasteDetailBean>post(RUBBISHDETAIL).tag(this)
                .params("id", id)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new JsonCallback<WasteDetailBean>(WasteDetailBean.class) {
                    @Override
                    public void onSuccess(Response<WasteDetailBean> response) {
                        mView.showWasteDetail(response.body());
                    }
                    @Override
                    public void onCacheSuccess(Response<WasteDetailBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }
                });

    }

    @Override
    public void getApprove(String id, String userId) {
        OkGo.<JsonBean>post(SAVECHECKRUBBISH).tag(this)
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
    public void getAuditFailure(String id, String userId, String auditReason) {
        OkGo.<JsonBean>post(SAVECHECKRUBBISH).tag(this)
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
