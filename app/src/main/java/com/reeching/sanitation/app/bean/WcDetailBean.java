package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/3/14.
 */

public class WcDetailBean  implements Serializable {


    /**
     * result : 1
     * msg : 获取成功！
     */

    private String result;
    private String msg;
    private InfosBean infos;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public InfosBean getInfos() {
        return infos;
    }

    public void setInfos(InfosBean infos) {
        this.infos = infos;
    }

    public static class InfosBean implements Serializable{
        /**
         * id : 8d15df690abf44f8b6ce8ae6da4127fc
         * isNewRecord : false
         * createDate : 2018-04-24 11:52:08
         * updateDate : 2018-04-24 11:52:08
         * number : 4324235
         * markNo : 2131243
         * name : 宇宙测试
         * checkName : VIP
         * mapLng :
         * mapLat :
         * belongArea : 朝阳
         * manageUnit :
         * workCompanyId : ae203f7a0ea74b86989e4b778f0352b4
         * companyName : 北京环境卫生工程集团有限公司
         * countType : 82e4608767cd45c9908fb8c902c64d20
         * checkArea : 13323
         * address :
         * tioletType : 3
         * tioletTypeName : 三类
         * tioletLevel : 1
         * flushingMethod :
         * malePosition : 10
         * femalePosition : 1
         * disabledPosition : 1
         * stationTotal : 12
         * barrierFacilities : 1
         * barrierFacilitiesName : 有
         * fecalTreatment :
         * manageType : 2
         * manageTypeName : 委托
         * managerNumber : 5
         * coveredArea : 112
         * operationSituation : 正常
         * openCloseTime : 2017-04-24
         * toiletPhoto : |/message/envirToilet/2018-04-24/1524541927646/fcb0f91f8f174bf8817c3169898834bd.jpg|/message/envirToilet/2018-04-24/1524541927648/69adfb110aea4b9f8a7cf6ae8f2b6722.jpg|/message/envirToilet/2018-04-24/1524541927656/0a5cb1fc786c4fd8ba629d38bfc9058e.png|/message/envirToilet/2018-04-24/1524541927659/a77fc5f54f254e3a9cf34dda948a41da.jpg
         * toiletsAroundPhoto :
         * auditStatus : 1
         * auditReason :
         * tioletClassName :
         * propertyRight : 1
         * propertyRightName : 朝阳区环卫中心
         * leader : a5c16e10e84c4c7db2f000063f5fe824
         * fieldTeam : 3
         * fieldTeamManager : cf2961e5a43d4cbaa061ca9433410829
         * fieldUnit : d15c0b745d634f90b2038c983ab4c83e
         * fieldUnitManager : 8fac047e15654c7c9c601b26e75af617
         * workTeam : 48a427347b214130863d4e52c840ca46
         * workTeamManager : 60b52f243ab54eaebbc1b37e15c0452b
         * leaderName : 关鹏
         * fieldTeamName : 四场
         * fieldTeamManagerName : 姚有法
         * fieldUnitName : 二分队
         * fieldUnitManagerName : 秦润珊
         * workTeamName : 常营班
         * workTeamManagerName : 贾改子
         * dataSource :
         * areaType : 2
         * areaTypeName : 地区
         * selfCheck : 正常
         * belongStreet : 071d11eb469b4e2b9b8f0b159052d8c4
         * belongCommunity : 5fc0d2ba0628495db0631c38707ba260
         * belongStreetName : 左家庄、麦子店
         * belongCommunityName : 三间房集体用地
         * remark : 无
         * urinalType :
         * urinalCount : 无
         * auditStatusName
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String number;
        private String markNo;
        private String name;
        private String checkName;
        private String mapLng;
        private String mapLat;
        private String belongArea;
        private String manageUnit;
        private String workCompanyId;
        private String companyName;
        private String countType;
        private String checkArea;
        private String address;
        private String tioletType;
        private String tioletTypeName;
        private String tioletLevel;
        private String flushingMethod;
        private String malePosition;
        private String femalePosition;
        private String disabledPosition;
        private String stationTotal;
        private String barrierFacilities;
        private String barrierFacilitiesName;
        private String fecalTreatment;
        private String manageType;
        private String manageTypeName;
        private String managerNumber;
        private String coveredArea;
        private String operationSituation;
        private String openCloseTime;
        private String toiletPhoto;
        private String toiletsAroundPhoto;
        private String auditStatus;
        private String auditReason;
        private String tioletClassName;
        private String propertyRight;
        private String propertyRightName;
        private String leader;
        private String fieldTeam;
        private String fieldTeamManager;
        private String fieldUnit;
        private String fieldUnitManager;
        private String workTeam;
        private String workTeamManager;
        private String leaderName;
        private String fieldTeamName;
        private String fieldTeamManagerName;
        private String fieldUnitName;
        private String fieldUnitManagerName;
        private String workTeamName;
        private String workTeamManagerName;
        private String dataSource;
        private String areaType;
        private String areaTypeName;
        private String selfCheck;
        private String belongStreet;
        private String belongCommunity;
        private String belongStreetName;
        private String belongCommunityName;
        private String remark;
        private String urinalType;
        private String urinalCount;
        private String objectKey;
        private String auditStatusName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getObjectKey() {
            return objectKey;
        }

        public void setObjectKey(String objectKey) {
            this.objectKey = objectKey;
        }
        public String getAuditStatusName() {
            return auditStatusName;
        }

        public void setAuditStatusName(String auditStatusName) {
            this.auditStatusName = auditStatusName;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getMarkNo() {
            return markNo;
        }

        public void setMarkNo(String markNo) {
            this.markNo = markNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCheckName() {
            return checkName;
        }

        public void setCheckName(String checkName) {
            this.checkName = checkName;
        }

        public String getMapLng() {
            return mapLng;
        }

        public void setMapLng(String mapLng) {
            this.mapLng = mapLng;
        }

        public String getMapLat() {
            return mapLat;
        }

        public void setMapLat(String mapLat) {
            this.mapLat = mapLat;
        }

        public String getBelongArea() {
            return belongArea;
        }

        public void setBelongArea(String belongArea) {
            this.belongArea = belongArea;
        }

        public String getManageUnit() {
            return manageUnit;
        }

        public void setManageUnit(String manageUnit) {
            this.manageUnit = manageUnit;
        }

        public String getWorkCompanyId() {
            return workCompanyId;
        }

        public void setWorkCompanyId(String workCompanyId) {
            this.workCompanyId = workCompanyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCountType() {
            return countType;
        }

        public void setCountType(String countType) {
            this.countType = countType;
        }

        public String getCheckArea() {
            return checkArea;
        }

        public void setCheckArea(String checkArea) {
            this.checkArea = checkArea;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTioletType() {
            return tioletType;
        }

        public void setTioletType(String tioletType) {
            this.tioletType = tioletType;
        }

        public String getTioletTypeName() {
            return tioletTypeName;
        }

        public void setTioletTypeName(String tioletTypeName) {
            this.tioletTypeName = tioletTypeName;
        }

        public String getTioletLevel() {
            return tioletLevel;
        }

        public void setTioletLevel(String tioletLevel) {
            this.tioletLevel = tioletLevel;
        }

        public String getFlushingMethod() {
            return flushingMethod;
        }

        public void setFlushingMethod(String flushingMethod) {
            this.flushingMethod = flushingMethod;
        }

        public String getMalePosition() {
            return malePosition;
        }

        public void setMalePosition(String malePosition) {
            this.malePosition = malePosition;
        }

        public String getFemalePosition() {
            return femalePosition;
        }

        public void setFemalePosition(String femalePosition) {
            this.femalePosition = femalePosition;
        }

        public String getDisabledPosition() {
            return disabledPosition;
        }

        public void setDisabledPosition(String disabledPosition) {
            this.disabledPosition = disabledPosition;
        }

        public String getStationTotal() {
            return stationTotal;
        }

        public void setStationTotal(String stationTotal) {
            this.stationTotal = stationTotal;
        }

        public String getBarrierFacilities() {
            return barrierFacilities;
        }

        public void setBarrierFacilities(String barrierFacilities) {
            this.barrierFacilities = barrierFacilities;
        }

        public String getBarrierFacilitiesName() {
            return barrierFacilitiesName;
        }

        public void setBarrierFacilitiesName(String barrierFacilitiesName) {
            this.barrierFacilitiesName = barrierFacilitiesName;
        }

        public String getFecalTreatment() {
            return fecalTreatment;
        }

        public void setFecalTreatment(String fecalTreatment) {
            this.fecalTreatment = fecalTreatment;
        }

        public String getManageType() {
            return manageType;
        }

        public void setManageType(String manageType) {
            this.manageType = manageType;
        }

        public String getManageTypeName() {
            return manageTypeName;
        }

        public void setManageTypeName(String manageTypeName) {
            this.manageTypeName = manageTypeName;
        }

        public String getManagerNumber() {
            return managerNumber;
        }

        public void setManagerNumber(String managerNumber) {
            this.managerNumber = managerNumber;
        }

        public String getCoveredArea() {
            return coveredArea;
        }

        public void setCoveredArea(String coveredArea) {
            this.coveredArea = coveredArea;
        }

        public String getOperationSituation() {
            return operationSituation;
        }

        public void setOperationSituation(String operationSituation) {
            this.operationSituation = operationSituation;
        }

        public String getOpenCloseTime() {
            return openCloseTime;
        }

        public void setOpenCloseTime(String openCloseTime) {
            this.openCloseTime = openCloseTime;
        }

        public String getToiletPhoto() {
            return toiletPhoto;
        }

        public void setToiletPhoto(String toiletPhoto) {
            this.toiletPhoto = toiletPhoto;
        }

        public String getToiletsAroundPhoto() {
            return toiletsAroundPhoto;
        }

        public void setToiletsAroundPhoto(String toiletsAroundPhoto) {
            this.toiletsAroundPhoto = toiletsAroundPhoto;
        }

        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }

        public String getAuditReason() {
            return auditReason;
        }

        public void setAuditReason(String auditReason) {
            this.auditReason = auditReason;
        }

        public String getTioletClassName() {
            return tioletClassName;
        }

        public void setTioletClassName(String tioletClassName) {
            this.tioletClassName = tioletClassName;
        }

        public String getPropertyRight() {
            return propertyRight;
        }

        public void setPropertyRight(String propertyRight) {
            this.propertyRight = propertyRight;
        }

        public String getPropertyRightName() {
            return propertyRightName;
        }

        public void setPropertyRightName(String propertyRightName) {
            this.propertyRightName = propertyRightName;
        }

        public String getLeader() {
            return leader;
        }

        public void setLeader(String leader) {
            this.leader = leader;
        }

        public String getFieldTeam() {
            return fieldTeam;
        }

        public void setFieldTeam(String fieldTeam) {
            this.fieldTeam = fieldTeam;
        }

        public String getFieldTeamManager() {
            return fieldTeamManager;
        }

        public void setFieldTeamManager(String fieldTeamManager) {
            this.fieldTeamManager = fieldTeamManager;
        }

        public String getFieldUnit() {
            return fieldUnit;
        }

        public void setFieldUnit(String fieldUnit) {
            this.fieldUnit = fieldUnit;
        }

        public String getFieldUnitManager() {
            return fieldUnitManager;
        }

        public void setFieldUnitManager(String fieldUnitManager) {
            this.fieldUnitManager = fieldUnitManager;
        }

        public String getWorkTeam() {
            return workTeam;
        }

        public void setWorkTeam(String workTeam) {
            this.workTeam = workTeam;
        }

        public String getWorkTeamManager() {
            return workTeamManager;
        }

        public void setWorkTeamManager(String workTeamManager) {
            this.workTeamManager = workTeamManager;
        }

        public String getLeaderName() {
            return leaderName;
        }

        public void setLeaderName(String leaderName) {
            this.leaderName = leaderName;
        }

        public String getFieldTeamName() {
            return fieldTeamName;
        }

        public void setFieldTeamName(String fieldTeamName) {
            this.fieldTeamName = fieldTeamName;
        }

        public String getFieldTeamManagerName() {
            return fieldTeamManagerName;
        }

        public void setFieldTeamManagerName(String fieldTeamManagerName) {
            this.fieldTeamManagerName = fieldTeamManagerName;
        }

        public String getFieldUnitName() {
            return fieldUnitName;
        }

        public void setFieldUnitName(String fieldUnitName) {
            this.fieldUnitName = fieldUnitName;
        }

        public String getFieldUnitManagerName() {
            return fieldUnitManagerName;
        }

        public void setFieldUnitManagerName(String fieldUnitManagerName) {
            this.fieldUnitManagerName = fieldUnitManagerName;
        }

        public String getWorkTeamName() {
            return workTeamName;
        }

        public void setWorkTeamName(String workTeamName) {
            this.workTeamName = workTeamName;
        }

        public String getWorkTeamManagerName() {
            return workTeamManagerName;
        }

        public void setWorkTeamManagerName(String workTeamManagerName) {
            this.workTeamManagerName = workTeamManagerName;
        }

        public String getDataSource() {
            return dataSource;
        }

        public void setDataSource(String dataSource) {
            this.dataSource = dataSource;
        }

        public String getAreaType() {
            return areaType;
        }

        public void setAreaType(String areaType) {
            this.areaType = areaType;
        }

        public String getAreaTypeName() {
            return areaTypeName;
        }

        public void setAreaTypeName(String areaTypeName) {
            this.areaTypeName = areaTypeName;
        }

        public String getSelfCheck() {
            return selfCheck;
        }

        public void setSelfCheck(String selfCheck) {
            this.selfCheck = selfCheck;
        }

        public String getBelongStreet() {
            return belongStreet;
        }

        public void setBelongStreet(String belongStreet) {
            this.belongStreet = belongStreet;
        }

        public String getBelongCommunity() {
            return belongCommunity;
        }

        public void setBelongCommunity(String belongCommunity) {
            this.belongCommunity = belongCommunity;
        }

        public String getBelongStreetName() {
            return belongStreetName;
        }

        public void setBelongStreetName(String belongStreetName) {
            this.belongStreetName = belongStreetName;
        }

        public String getBelongCommunityName() {
            return belongCommunityName;
        }

        public void setBelongCommunityName(String belongCommunityName) {
            this.belongCommunityName = belongCommunityName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUrinalType() {
            return urinalType;
        }

        public void setUrinalType(String urinalType) {
            this.urinalType = urinalType;
        }

        public String getUrinalCount() {
            return urinalCount;
        }

        public void setUrinalCount(String urinalCount) {
            this.urinalCount = urinalCount;
        }
    }
}
