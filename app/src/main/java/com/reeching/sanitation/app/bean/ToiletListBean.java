package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/1/29.
 */

public class ToiletListBean implements Serializable {


    /**
     * result : 1
     * msg : 获取成功！
     */

    private String result;
    private String msg;
    private List<InfosBean> infos;

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

    public List<InfosBean> getInfos() {
        return infos;
    }

    public void setInfos(List<InfosBean> infos) {
        this.infos = infos;
    }

    public static class InfosBean implements Serializable{
        /**
         * id : a9f7ce75b5ab4bf8933f2634f3fbef08
         * isNewRecord : false
         * createDate : 2018-01-04 11:49:45
         * updateDate : 2018-03-15 19:13:31
         * number : 1051020000840
         * markNo : G1415
         * name : 海棠公园南
         * checkName : 海棠公园南
         * mapLng : 512481.92101757
         * mapLat : 296352.13314757
         * belongArea : 朝阳区
         * workCompanyId : 66db0055ee2d42a0910af02f1c56d068
         * companyName : 三队
         * address : 海棠公园南
         * tioletType : 2
         * tioletTypeName : 二类
         * malePosition : 0
         * femalePosition : 0
         * disabledPosition : 0
         * stationTotal : 0
         * barrierFacilitiesName :
         * manageTypeName :
         * toiletPhoto :
         * toiletsAroundPhoto :
         * auditStatus : 1
         * tioletClass : 1
         * tioletClassName : 公共厕所
         * propertyRight : 1
         * propertyRightName : 朝阳区环卫中心
         * leader : a092ca9b225b405a9ffebcd7a0a6a3c0
         * fieldTeam : 2
         * fieldTeamManager : c4b0d3a3a0f447eaa90d2016ced56716
         * leaderName : 赵振兵
         * fieldTeamName : 朝环三队
         * fieldTeamManagerName : 王月玲
         * belongGrid : 11010520220802
         * areaType : 2
         * areaTypeName : 地区
         * selfCheck :
         * belongStreet : cde920ba07fb4772b3ae7f1eb6127139
         * belongCommunity : 30fa98d572bd41589043f3dc5cb90259
         * belongStreetName : 十八里店地区
         * belongCommunityName : 横街村
         * manageUnit : 11
         * checkArea : 11
         * tioletLevel : 1
         * barrierFacilities : 2
         * manageType : 1
         * managerNumber : 11
         * coveredArea : 11
         * operationSituation : 11
         * openCloseTime : 11
         * auditReason : 11
         * fieldUnit : d15c0b745d634f90b2038c983ab4c83e
         * fieldUnitManager : 37c65bdc4a244d84b980c2e564f4fcf7
         * workTeam : 48a427347b214130863d4e52c840ca46
         * workTeamManager : 60b52f243ab54eaebbc1b37e15c0452b
         * fieldUnitName : 二分队
         * fieldUnitManagerName : 刘波
         * workTeamName : 常营班
         * workTeamManagerName : 贾改子
         * dataSource : 11
         * remark : 11
         * urinalType : 11
         * urinalCount : 11
         * tioletLevelName :
         * manageUnitName : 北京朝阳区
         * objectKey : 1126863机场街道 南平里社区 机场体育场西
         * accessUseTime : 1519975068000
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
        private String workCompanyId;
        private String companyName;
        private String address;
        private String tioletType;
        private String tioletTypeName;
        private String malePosition;
        private String femalePosition;
        private String disabledPosition;
        private String stationTotal;
        private String barrierFacilitiesName;
        private String manageTypeName;
        private String toiletPhoto;
        private String toiletsAroundPhoto;
        private String auditStatus;
        private String tioletClass;
        private String tioletClassName;
        private String propertyRight;
        private String propertyRightName;
        private String leader;
        private String fieldTeam;
        private String fieldTeamManager;
        private String leaderName;
        private String fieldTeamName;
        private String fieldTeamManagerName;
        private String belongGrid;
        private String areaType;
        private String areaTypeName;
        private String selfCheck;
        private String belongStreet;
        private String belongCommunity;
        private String belongStreetName;
        private String belongCommunityName;
        private String manageUnit;
        private String checkArea;
        private String tioletLevel;
        private String barrierFacilities;
        private String manageType;
        private String managerNumber;
        private String coveredArea;
        private String operationSituation;
        private String openCloseTime;
        private String auditReason;
        private String fieldUnit;
        private String fieldUnitManager;
        private String workTeam;
        private String workTeamManager;
        private String fieldUnitName;
        private String fieldUnitManagerName;
        private String workTeamName;
        private String workTeamManagerName;
        private String dataSource;
        private String remark;
        private String urinalType;
        private String urinalCount;
        private String tioletLevelName;
        private String manageUnitName;
        private String objectKey;
        private long accessUseTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getBarrierFacilitiesName() {
            return barrierFacilitiesName;
        }

        public void setBarrierFacilitiesName(String barrierFacilitiesName) {
            this.barrierFacilitiesName = barrierFacilitiesName;
        }

        public String getManageTypeName() {
            return manageTypeName;
        }

        public void setManageTypeName(String manageTypeName) {
            this.manageTypeName = manageTypeName;
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

        public String getTioletClass() {
            return tioletClass;
        }

        public void setTioletClass(String tioletClass) {
            this.tioletClass = tioletClass;
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

        public String getBelongGrid() {
            return belongGrid;
        }

        public void setBelongGrid(String belongGrid) {
            this.belongGrid = belongGrid;
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

        public String getManageUnit() {
            return manageUnit;
        }

        public void setManageUnit(String manageUnit) {
            this.manageUnit = manageUnit;
        }

        public String getCheckArea() {
            return checkArea;
        }

        public void setCheckArea(String checkArea) {
            this.checkArea = checkArea;
        }

        public String getTioletLevel() {
            return tioletLevel;
        }

        public void setTioletLevel(String tioletLevel) {
            this.tioletLevel = tioletLevel;
        }

        public String getBarrierFacilities() {
            return barrierFacilities;
        }

        public void setBarrierFacilities(String barrierFacilities) {
            this.barrierFacilities = barrierFacilities;
        }

        public String getManageType() {
            return manageType;
        }

        public void setManageType(String manageType) {
            this.manageType = manageType;
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

        public String getAuditReason() {
            return auditReason;
        }

        public void setAuditReason(String auditReason) {
            this.auditReason = auditReason;
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

        public String getTioletLevelName() {
            return tioletLevelName;
        }

        public void setTioletLevelName(String tioletLevelName) {
            this.tioletLevelName = tioletLevelName;
        }

        public String getManageUnitName() {
            return manageUnitName;
        }

        public void setManageUnitName(String manageUnitName) {
            this.manageUnitName = manageUnitName;
        }

        public String getObjectKey() {
            return objectKey;
        }

        public void setObjectKey(String objectKey) {
            this.objectKey = objectKey;
        }

        public long getAccessUseTime() {
            return accessUseTime;
        }

        public void setAccessUseTime(long accessUseTime) {
            this.accessUseTime = accessUseTime;
        }
    }
}
