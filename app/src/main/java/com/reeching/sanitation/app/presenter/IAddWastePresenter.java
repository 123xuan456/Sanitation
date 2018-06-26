package com.reeching.sanitation.app.presenter;

import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;
import com.reeching.sanitation.app.base.RxPresenter;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;
import com.reeching.sanitation.app.contract.AddWasteContract;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import static com.reeching.sanitation.app.contant.Contants.CHECKMARKNORUBBISH;
import static com.reeching.sanitation.app.contant.Contants.CHECKNUMBERRUBBISH;
import static com.reeching.sanitation.app.contant.Contants.FINDBASEID;
import static com.reeching.sanitation.app.contant.Contants.FINDWORKCOMPANY;
import static com.reeching.sanitation.app.contant.Contants.GETSELECTLIST;
import static com.reeching.sanitation.app.contant.Contants.SAVERUBBISH;

/**
 * Created by 绍轩 on 2017/12/14.
 * 垃圾篓
 */

public class IAddWastePresenter extends RxPresenter<AddWasteContract.View> implements AddWasteContract.Presenter<AddWasteContract.View> {


    @Inject
    public IAddWastePresenter() {
    }


    @Override
    public void checkMarkNoToilet(String etNum) {
        if (!TextUtils.isEmpty(etNum)) {
            OkGo.<JsonBean>post(CHECKMARKNORUBBISH).tag(this)
                    .params("id", "")
                    .params("markNo", etNum)
                    .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                        @Override
                        public void onSuccess(Response<JsonBean> response) {
                            JsonBean jsonBean = response.body();
                            mView.showAddNum(jsonBean.getResult());
                        }
                    });
        }
    }
    //编号
    @Override
    public void checkNumberToilet(String s) {
        if (!TextUtils.isEmpty(s)) {
            OkGo.<JsonBean>post(CHECKNUMBERRUBBISH).tag(this)
                    .params("id", "")
                    .params("rubbishNo", s)
                    .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                        @Override
                        public void onSuccess(Response<JsonBean> response) {
                            JsonBean jsonBean = response.body();
                            mView.showAddNumber(jsonBean.getResult());
                        }
                    });
        }
    }

    @Override
    public void getObjectKeySpinner() {
        OkGo.<FindBaseIdBean>post(FINDBASEID).tag(this)
                .params("objectTypeId", 300507)
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
                    public void onFinish() {
                        super.onFinish();

                    }
                });
    }

    @Override
    public void getWorkCompanySpinner() {
        OkGo.<WorkCompanyBean>get(FINDWORKCOMPANY).tag(this)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
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
                        onSuccess(response);
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
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
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
                    public void onCacheSuccess(Response<AddSpinnerBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
                    }
                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });


    }

    @Override
    public void getPropertyRightSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "propertyRight")
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showPropertyRightSpinner(info);
                        }
                    }
                    @Override
                    public void onCacheSuccess(Response<AddSpinnerBean> response) {
                        super.onCacheSuccess(response);
                        onSuccess(response);
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
    public void saveMessage(String userId, String baseId, String markNo, String rubbishName,
                            String rubbishNo, String type, String rubbishClass, String address,
                            String propertyRight, String leader, String fieldTeam, String fieldTeamManager,
                            String fieldUnit, String fieldUnitManager, String workTeam, String workTeamManager,
                            String selfCheck, String workCompanyId, String belongStreet, String belongCommunity,
                            String belongGrid, String photoa, String photob, String areaType, String auditStatus,
                            String auditReason, String remark, File photo, List<File> photos) {
        PostRequest<JsonBean> a = OkGo.<JsonBean>post(SAVERUBBISH).tag(this)
                .params("userId", userId).params("baseId", baseId).params("markNo", markNo).params("rubbishName", rubbishName)
                .params("rubbishNo", rubbishNo).params("type", type).params("rubbishClass", rubbishClass).params("address", address)
                .params("propertyRight", propertyRight).params("leader", leader).params("fieldTeam", fieldTeam).params("fieldTeamManager", fieldTeamManager)
                .params("fieldUnit", fieldUnit).params("fieldUnitManager", fieldUnitManager).params("workTeam", workTeam).params("workTeamManager", workTeamManager)
                .params("selfCheck", selfCheck).params("workCompanyId", workCompanyId).params("belongStreet", belongStreet).params("belongCommunity", belongCommunity)
                .params("belongGrid", belongGrid).params("photoa", photoa).params("photob", photob).params("areaType", areaType)
                .params("auditStatus", auditStatus).params("auditReason", auditReason).params("remark", remark);
        for (int i = 0; i < photos.size(); i++) {
            String Photo1 = photos.get(i).getPath();
            a.params("PhotoFiles" + (i + 1), new File(Photo1));
        }
        if (photo != null) {
            a.params("photo", photo);
        }
        a.execute(new JsonCallback<JsonBean>(JsonBean.class) {
            @Override
            public void onSuccess(Response<JsonBean> response) {
                JsonBean jsonBean = response.body();
                String s = jsonBean.getResult();
                 mView.showSaveMessage(s);
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
