package com.reeching.sanitation.app.contract;

import com.reeching.sanitation.app.base.BaseContract;
import com.reeching.sanitation.app.bean.WcDetailBean;

/**
 * Created by 绍轩 on 2018/3/7.
 * 垃圾篓
 */

public interface DetailsWcContract {
    interface View extends BaseContract.BaseView {
        void showWcDetail(WcDetailBean data);
        //审核通过
        void showApprove(String res);
        //审核不通过
        void showAuditFailure(String res);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getWcDetails(String id);

        void getApprove(String id,String userId);
        void getAuditFailure(String id,String userId,String auditReason);

    }


}
