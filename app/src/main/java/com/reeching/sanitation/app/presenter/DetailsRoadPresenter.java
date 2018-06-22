package com.reeching.sanitation.app.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.app.base.RxPresenter;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.RoadDetailBean;
import com.reeching.sanitation.app.contract.DetailsRoadContract;
import com.reeching.sanitation.app.util.JsonCallback;

import javax.inject.Inject;

import static com.reeching.sanitation.app.contant.Contants.SAVECHECKSTREET;
import static com.reeching.sanitation.app.contant.Contants.STREETDETAIL;

/**
 * Created by 绍轩 on 2017/12/14.
 */

public class DetailsRoadPresenter extends RxPresenter<DetailsRoadContract.View> implements DetailsRoadContract.Presenter<DetailsRoadContract.View> {


    @Inject
    public DetailsRoadPresenter() {
    }

    @Override
    public void getRoadDetails(String id) {
        OkGo.<RoadDetailBean>post(STREETDETAIL).tag(this)
                .params("id", id)
                .execute(new JsonCallback<RoadDetailBean>(RoadDetailBean.class) {
                    @Override
                    public void onSuccess(Response<RoadDetailBean> response) {
                            mView.showRoadDetail(response.body());
                    }
                });


    }

    @Override
    public void getApprove(String id, String userId) {
        OkGo.<JsonBean>post(SAVECHECKSTREET).tag(this)
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
        OkGo.<JsonBean>post(SAVECHECKSTREET).tag(this)
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
