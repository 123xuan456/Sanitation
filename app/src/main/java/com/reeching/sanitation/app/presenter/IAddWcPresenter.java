package com.reeching.sanitation.app.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.PostRequest;
import com.reeching.sanitation.app.contract.AddBasicsViewContract;
import com.reeching.sanitation.app.base.RxPresenter;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.JsonBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;
import com.reeching.sanitation.app.util.JsonCallback;
import com.reeching.sanitation.app.util.LogUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.reeching.sanitation.app.contant.Contants.CHECKMARKNOTOILET;
import static com.reeching.sanitation.app.contant.Contants.CHECKNUMBERTOILET;
import static com.reeching.sanitation.app.contant.Contants.FINDBASEID;
import static com.reeching.sanitation.app.contant.Contants.FINDWORKCOMPANY;
import static com.reeching.sanitation.app.contant.Contants.GETSELECTLIST;
import static com.reeching.sanitation.app.contant.Contants.SAVETOILET;

/**
 * Created by 绍轩 on 2017/12/14.
 */

public class IAddWcPresenter extends RxPresenter<AddBasicsViewContract.View> implements AddBasicsViewContract.Presenter<AddBasicsViewContract.View> {


    @Inject
    public IAddWcPresenter() {
    }

    public void checkMarkNoToilet(String etNum) {
        OkGo.<JsonBean>post(CHECKMARKNOTOILET).tag(this)
                .params("id", "")
                .params("markNo", etNum)
                .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                    @Override
                    public void onSuccess(Response<JsonBean> response) {
                        JsonBean jsonBean = response.body();
                        mView.showAddNum(jsonBean.getResult());
                        LogUtils.i(jsonBean.getMsg());
                    }
                });
    }

    public void checkNumberToilet(String etNum) {
        OkGo.<JsonBean>post(CHECKNUMBERTOILET).tag(this)
                .params("id", "")
                .params("markNo", etNum)
                .execute(new JsonCallback<JsonBean>(JsonBean.class) {
                    @Override
                    public void onSuccess(Response<JsonBean> response) {
                        JsonBean jsonBean = response.body();
                        mView.showAddNumber(jsonBean.getResult());
                        LogUtils.i(jsonBean.getMsg());
                    }
                });
    }

    @Override
    public void getObjectKeySpinner() {
        OkGo.<FindBaseIdBean>post(FINDBASEID).tag(this)
                .params("objectTypeId", 200505)
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
                    public void onFinish() {
                        super.onFinish();

                    }
                });
    }

    @Override
    public void getTioletClassSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "tioletClass")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showTioletClassSpinner(info);
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
    public void getPropertyRightSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "propertyRight")
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
    public void getTioletLevelSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "tioletLevel")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showTioletLevelSpinner(info);
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
    public void getBarrierFacilitiesSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "barrierFacilities")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showBarrierFacilitiesSpinner(info);
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
    public void getTioletTypeSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "tioletType")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showTioletTypeSpinner(info);
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
    public void getManageTypeSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "manageType")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showManageTypeSpinner(info);
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
    public void getOperationSpinner() {
        OkGo.<AddSpinnerBean>post(GETSELECTLIST).tag(this)
                .params("type", "operation")
                .execute(new JsonCallback<AddSpinnerBean>(AddSpinnerBean.class) {
                    @Override
                    public void onSuccess(Response<AddSpinnerBean> response) {
                        AddSpinnerBean addSpinnerBean = response.body();
                        if (addSpinnerBean.getResult().equals("1")) {
                            List<AddSpinnerBean.InfosBean> info = addSpinnerBean.getInfos();
                            mView.showOperationSpinner(info);
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
    public void saveMessage(String userId, String number, String markNo, String name, String checkName, String belongArea,
                            String manageUnit, String workCompanyId, String companyName, String checkArea, String tioletType,
                            String tioletLevel, String malePosition, String femalePosition, String disabledPosition, String stationTotal,
                            String barrierFacilities, String manageType, String managerNumber, String coveredArea,
                            String operationSituation, String openCloseTime, String toiletPhoto, File toiletPhotoFile, String toiletsAroundPhoto,
                            ArrayList<File> toiletsAroundPhotoFiles,
                            String accessUseTime, String submitAuditTime, String tioletClass, String propertyRight, String leader,
                            String fieldTeam, String fieldTeamManager, String fieldUnit, String fieldUnitManager, String workTeam,
                            String workTeamManager, String areaType, String selfCheck, String belongStreet, String belongCommunity,
                            String remark, String urinalType, String urinalCount, String dataSource, String countType, String baseId,

                            String auditReason, String auditStatus, String useDate, String fecalTreatment, String flushingMethod,
                            String address, String mapLat, String mapLng) {

        PostRequest<JsonBean> a = OkGo.<JsonBean>post(SAVETOILET).tag(this)

                .params("userId", userId).params("number", number).params("markNo", markNo).params("name", name)
                .params("checkName", checkName).params("belongArea", belongArea).params("manageUnit", manageUnit)
                .params("workCompanyId", "ae203f7a0ea74b86989e4b778f0352b4")
                .params("companyName", companyName).params("checkArea", checkArea).params("tioletType", tioletType).params("tioletLevel", tioletLevel)
                .params("malePosition", malePosition).params("femalePosition", femalePosition).params("disabledPosition", disabledPosition).params("stationTotal", stationTotal)
                .params("barrierFacilities", barrierFacilities).params("manageType", manageType).params("managerNumber", managerNumber).params("coveredArea", coveredArea)
                .params("operationSituation", operationSituation)
                .params("toiletPhoto", toiletPhoto)
                .params("toiletsAroundPhoto", toiletsAroundPhoto)
                .params("openCloseTime", openCloseTime)
//                .params("accessUseTime", "")
//                .params("useDate", "")
//                .params("submitAuditTime", "")
                .params("toiletClass", tioletClass)
                .params("propertyRight", propertyRight)
                .params("leader", leader).params("fieldTeam", fieldTeam).params("fieldTeamManager", fieldTeamManager)
                .params("fieldUnit", fieldUnit)
                .params("fieldUnitManager", fieldUnitManager).params("workTeam", workTeam).params("workTeamManager", workTeamManager)
                .params("areaType", areaType)
                .params("selfCheck", selfCheck).params("belongStreet", belongStreet).params("belongCommunity", belongCommunity).params("remark", remark)
                .params("urinalType", urinalType).params("dataSource", dataSource).params("countType", countType).
                        params("baseId", baseId)
                .params("auditReason", auditReason).params("urinalCount", urinalCount).params("auditStatus", auditStatus)
                .params("fecalTreatment", fecalTreatment).params("flushingMethod", flushingMethod).params("address", address).params("mapLat", mapLat)
                .params("mapLng", mapLng);
        for (int i = 0; i < toiletsAroundPhotoFiles.size(); i++) {
            String toiletsAroundPhoto1 = toiletsAroundPhotoFiles.get(i).getPath();
            a.params("toiletsAroundPhotoFiles" + (i + 1), new File(toiletsAroundPhoto1));
        }
        if (toiletPhotoFile != null) {
            a.params("toiletPhotoFile", toiletPhotoFile);
        }
        a.execute(new JsonCallback<JsonBean>(JsonBean.class) {
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
//
//        HttpUtils hu = new HttpUtils();
//        RequestParams params = new RequestParams();
//        params.addBodyParameter("workCompanyId", "ae203f7a0ea74b86989e4b778f0352b4");
////        params.addBodyParameter("accessUseTime", "2016.01.01");
//        hu.send(HttpRequest.HttpMethod.POST, SAVETOILET, params, new RequestCallBack<String>() {
//            @Override
//            public void onSuccess(ResponseInfo<String> responseInfo) {
//                String a = responseInfo.result;
//
//            }
//
//            @Override
//            public void onFailure(HttpException e, String s) {
//                LogUtils.i("传输失败！");
//            }
//        });

    }


}
