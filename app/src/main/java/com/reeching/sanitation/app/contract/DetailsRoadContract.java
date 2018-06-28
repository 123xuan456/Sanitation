package com.reeching.sanitation.app.contract;

import com.reeching.sanitation.app.base.BaseContract;
import com.reeching.sanitation.app.bean.RoadDetailBean;

/**
 * Created by 绍轩 on 2018/3/7.
 * 垃圾楼
 */

public interface DetailsRoadContract {
    interface View extends BaseContract.BaseView {
        void showRoadDetail(RoadDetailBean data);
        //审核通过
        void showApprove(String res);
        //审核不通过
        void showAuditFailure(String res);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getRoadDetails(String id);
        void getApprove(String id,String userId);
        void getAuditFailure(String id,String userId,String auditReason);
    }


}
