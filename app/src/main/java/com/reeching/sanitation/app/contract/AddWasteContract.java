package com.reeching.sanitation.app.contract;

import com.reeching.sanitation.app.base.BaseContract;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;

import java.io.File;
import java.util.List;

/**
 * Created by 绍轩 on 2018/3/7.
 * 垃圾篓
 */

public interface AddWasteContract {
    interface View extends BaseContract.BaseView {
        void showAddNum(String data);
        void showAddNumber(String data);

        void showObjectKeySpinner(List<FindBaseIdBean.InfosBean> list);
        //委托公司Id
        void showWorkCompanySpinner(List<WorkCompanyBean.InfosBean> list);
        //区域
        void showAreaTypeSpinner(List<AddSpinnerBean.InfosBean> list);
        //产权权属
        void showPropertyRightSpinner(List<AddSpinnerBean.InfosBean> list);


        void showSaveMessage(String s);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void checkMarkNoToilet(String s);
        void checkNumberToilet(String s);

        void getObjectKeySpinner();

        void getWorkCompanySpinner();

        void getAreaTypeSpinner();

        void getPropertyRightSpinner();

        void saveMessage(String userId, String baseId, String markNo, String rubbishName, String rubbishNo, String type, String rubbishClass, String address,
                         String propertyRight, String leader, String fieldTeam, String fieldTeamManager, String fieldUnit, String fieldUnitManager, String workTeam,
                         String workTeamManager, String selfCheck, String workCompanyId, String belongStreet, String belongCommunity, String belongGrid, String photoa,
                         String photob, String areaType, String auditStatus, String auditReason, String remark, File photo, List<File> photos);


    }


}
