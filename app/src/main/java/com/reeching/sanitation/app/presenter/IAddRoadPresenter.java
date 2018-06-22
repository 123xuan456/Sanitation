package com.reeching.sanitation.app.presenter;

import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.reeching.sanitation.app.base.RxPresenter;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;
import com.reeching.sanitation.app.contract.AddRoadContract;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;

import java.util.List;

import javax.inject.Inject;

import static com.reeching.sanitation.app.contant.Contants.CHECKMARKNOSTREET;
import static com.reeching.sanitation.app.contant.Contants.FINDBASEID;
import static com.reeching.sanitation.app.contant.Contants.FINDWORKCOMPANY;
import static com.reeching.sanitation.app.contant.Contants.GETSELECTLIST;
import static com.reeching.sanitation.app.contant.Contants.SAVESTREET;

/**
 * Created by 绍轩 on 2018/3/13.
 */

public class IAddRoadPresenter extends RxPresenter<AddRoadContract.View> implements AddRoadContract.Presenter<AddRoadContract.View> {

    @Inject
    public IAddRoadPresenter() {

    }
    @Override
    public void checkMarkNoToilet(String s) {
        if (!TextUtils.isEmpty(s)) {
            OkGo.<JsonBean>post(CHECKMARKNOSTREET).tag(this)
                    .params("id", "")
                    .params("markNo", s)
                    .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                        @Override
                        public void onSuccess(Response<JsonBean> response) {
                            JsonBean jsonBean = response.body();
                            mView.showAddNum(jsonBean.getResult());
                            LogUtils.i(jsonBean.getMsg());
                        }
                    });
        }

    }


    @Override
    public void getObjectKeySpinner() {
        OkGo.<FindBaseIdBean>post(FINDBASEID).tag(this)
                .params("objectTypeId", 300503)
                .params("pageSize", 1000)
                .params("pageNo", 1)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new JsonCallback<FindBaseIdBean>(FindBaseIdBean.class) {

                    @Override
                    public void onSuccess(Response<FindBaseIdBean> response) {
                        FindBaseIdBean findBaseIdBean = response.body();
                        if (findBaseIdBean.getResult().equals("1")) {
                            List<FindBaseIdBean.InfosBean> info = findBaseIdBean.getInfos();
                            mView.showObjectKeySpinner(info);
                        }
                    }

                    @Override
                    public void onCacheSuccess(Response<FindBaseIdBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }

                    @Override
                    public void onError(Response<FindBaseIdBean> response) {
                        super.onError(response);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();

                    }
                });

    }

    @Override
    public void getWorkCompanySpinner() {
        OkGo.<WorkCompanyBean>get(FINDWORKCOMPANY).tag(this)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .cacheKey(FINDWORKCOMPANY)
                .execute(new JsonCallback<WorkCompanyBean>(WorkCompanyBean.class) {
                    @Override
                    public void onSuccess(Response<WorkCompanyBean> response) {
                        WorkCompanyBean workCompanyBean = response.body();
                        if (workCompanyBean.getResult().equals("1")) {
                            List<WorkCompanyBean.InfosBean> info = workCompanyBean.getInfos();
                            mView.showWorkCompanySpinner(info);
                        }
                    }

                    @Override
                    public void onCacheSuccess(Response<WorkCompanyBean> response) {
                        super.onCacheSuccess(response);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }

    @Override
    public void getAreaTypeSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "area_type")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showAreaTypeSpinner(info);
                        }
                    }

                    @Override
                    public void onError(Response<AddSpinnerBean> response) {
                        super.onError(response);
                        mView.showError();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }

    @Override
    public void getStreetLevelSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "streetLevel")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showStreetLevelSpinner(info);
                        }
                    }

                    @Override
                    public void onError(Response<AddSpinnerBean> response) {
                        super.onError(response);
                        mView.showError();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });



    }

    @Override
    public void getCompanyTypeSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "company_type")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showCompanyTypeSpinner(info);
                        }
                    }

                    @Override
                    public void onError(Response<AddSpinnerBean> response) {
                        super.onError(response);
                        mView.showError();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });


    }


    @Override
    public void saveMessage(String userId, String baseId, String markNo, String branchesNo, String streetName, String streetLevel, String streetStart,
                            String streetEnd, String leader, String fieldTeam, String fieldTeamManager, String fieldUnit,
                            String fieldUnitManager, String workTeam, String workTeamManager, String companyType,
                            String workCompanyId, String segmentNo, String streetSegment, String minStreetStart,
                            String maxStreetEnd, String belongStreet, String belongCommunity, String belongGrid,
                            String orderNo, String simpleNo, String submitAuditTime, String remark,String areaType) {
        OkGo.<JsonBean>post(SAVESTREET).tag(this)
                .params("userId",userId).params("baseId",baseId).params("markNo",markNo).params("branchesNo",branchesNo)
                .params("streetName",streetName).params("streetLevel",streetLevel).params("streetStart",streetStart).params("streetEnd",streetEnd)
                .params("leader",leader).params("fieldTeam",fieldTeam).params("fieldTeamManager",fieldTeamManager).params("fieldUnit",fieldUnit)
                .params("fieldUnitManager",fieldUnitManager).params("workTeam",workTeam).params("workTeamManager",workTeamManager).params("companyType",companyType)
                .params("workCompanyId",workCompanyId).params("segmentNo",segmentNo).params("streetSegment",streetSegment).params("minStreetStart",minStreetStart)
                .params("maxStreetEnd",maxStreetEnd).params("belongStreet",belongStreet).params("belongCommunity",belongCommunity).params("belongGrid",belongGrid)
                .params("orderNo",orderNo).params("simpleNo",simpleNo).params("remark",remark).params("areaType",areaType)
                .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                    @Override
                    public void onSuccess(Response<JsonBean> response) {
                        JsonBean jsonBean = response.body();
                        mView.showSaveMessage(jsonBean.getResult());
                    }

                    @Override
                    public void onError(Response<JsonBean> response) {
                        super.onError(response);
                        LogUtils.i(response.code());
                        LogUtils.i(response.message());
                    }
                });






    }


}
