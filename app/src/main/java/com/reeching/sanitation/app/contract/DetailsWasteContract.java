package com.reeching.sanitation.app.contract;

import com.reeching.sanitation.app.base.BaseContract;
import com.reeching.sanitation.app.bean.WasteDetailBean;

/**
 * Created by 绍轩 on 2018/3/7.
 * 垃圾篓
 */

public interface DetailsWasteContract {
    interface View extends BaseContract.BaseView {
        void showWasteDetail(WasteDetailBean data);
        //审核通过
        void showApprove(String res);
        //审核不通过
        void showAuditFailure(String res);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getWasteDetails(String id);
        void getApprove(String id,String userId);
        void getAuditFailure(String id,String userId,String auditReason);
    }


}
