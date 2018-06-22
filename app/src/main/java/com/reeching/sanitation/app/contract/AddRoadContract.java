package com.reeching.sanitation.app.contract;

import com.reeching.sanitation.app.base.BaseContract;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;

import java.util.List;

/**
 * Created by 绍轩 on 2018/3/7.
 */

public interface AddRoadContract {
    interface View extends BaseContract.BaseView {
        void showAddNum(String data);

        void showObjectKeySpinner(List<FindBaseIdBean.InfosBean> list);
        //委托公司
        void showWorkCompanySpinner(List<WorkCompanyBean.InfosBean> list);
        //区域
        void showAreaTypeSpinner(List<AddSpinnerBean.InfosBean> list);
        //道路级别
        void showStreetLevelSpinner(List<AddSpinnerBean.InfosBean> list);
        //委托公司
        void showCompanyTypeSpinner(List<AddSpinnerBean.InfosBean> list);


        void showSaveMessage(String s);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void checkMarkNoToilet(String s);

        void getObjectKeySpinner();

        void getWorkCompanySpinner();


        void getAreaTypeSpinner();

        void getStreetLevelSpinner();
        void getCompanyTypeSpinner();

        void saveMessage(String userId,String baseId, String markNo, String branchesNo, String streetName, String streetLevel, String streetStart, String streetEnd,
                         String leader, String fieldTeam, String fieldTeamManager, String fieldUnit, String fieldUnitManager, String workTeam, String workTeamManager,
                         String companyType, String workCompanyId, String segmentNo, String streetSegment, String minStreetStart, String maxStreetEnd, String belongStreet,
                         String belongCommunity, String belongGrid, String orderNo, String simpleNo, String submitAuditTime, String remark,String areaType);


    }


}
