package com.reeching.sanitation.app.contract;

import com.reeching.sanitation.app.base.BaseContract;
import com.reeching.sanitation.app.bean.AddSpinnerBean;
import com.reeching.sanitation.app.bean.FindBaseIdBean;
import com.reeching.sanitation.app.bean.WorkCompanyBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 绍轩 on 2018/3/7.
 */

public interface AddBasicsViewContract {
    interface View extends BaseContract.BaseView {
        void showAddNum(String data);

        void showAddNumber(String data);

        void showObjectKeySpinner(List<FindBaseIdBean.InfosBean> list);

        void showWorkCompanySpinner(List<WorkCompanyBean.InfosBean> list);

        void showTioletClassSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showPropertyRightSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showTioletLevelSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showBarrierFacilitiesSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showTioletTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showManageTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showAreaTypeSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);

        void showOperationSpinner(List<AddSpinnerBean.InfosBean> spinnerBeanList);
        void showSaveMessage(String s);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void checkMarkNoToilet(String s);

        void checkNumberToilet(String s);

        void getObjectKeySpinner();

        void getWorkCompanySpinner();

        void getTioletClassSpinner();

        void getPropertyRightSpinner();

        void getTioletLevelSpinner();

        void getTioletTypeSpinner();

        void getBarrierFacilitiesSpinner();

        void getManageTypeSpinner();

        void getAreaTypeSpinner();

        void getOperationSpinner();

        void saveMessage(String userId , String number, String markNo, String name, String checkName, String belongArea, String manageUnit,
                         String workCompanyId, String companyName, String checkArea, String tioletType, String tioletLevel, String malePosition,
                         String femalePosition, String disabledPosition, String stationTotal, String barrierFacilities,
                         String manageType, String managerNumber, String coveredArea, String operationSituation, String openCloseTime,
                         String toiletPhoto, File toiletPhotoFile , String toiletsAroundPhoto, ArrayList<File> toiletsAroundPhotoFiles, String accessUseTime, String submitAuditTime, String tioletClass,
                         String propertyRight, String leader, String fieldTeam, String fieldTeamManager, String fieldUnit, String fieldUnitManager,
                         String workTeam, String workTeamManager, String areaType, String selfCheck, String belongStreet, String belongCommunity,
                         String remark, String urinalType, String urinalCount, String dataSource, String countType, String baseId, String auditReason,
                         String auditStatus, String useDate, String fecalTreatment, String flushingMethod, String address, String mapLat, String mapLng
                         );


    }


}
