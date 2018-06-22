package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/3/14.
 */

public class RoadDetailBean implements Serializable {


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
         * id : dec26aa04866457798e3546a7707c739
         * isNewRecord : false
         * createDate : 2018-04-24 16:02:59
         * updateDate : 2018-04-24 16:02:59
         * markNo : 123123
         * branchesNo : 321321
         * streetName : 12412
         * streetLevel : 1
         * streetStart : 32131
         * streetEnd : 123
         * leader : 4ae526e6380e46559c00b9a8e315d4a1
         * fieldTeam : 3
         * fieldTeamManager : cf2961e5a43d4cbaa061ca9433410829
         * fieldUnit : d15c0b745d634f90b2038c983ab4c83e
         * fieldUnitManager : 37c65bdc4a244d84b980c2e564f4fcf7
         * workTeam : 48a427347b214130863d4e52c840ca46
         * workTeamManager : 60b52f243ab54eaebbc1b37e15c0452b
         * leaderName : 刘小亮
         * fieldTeamName : 四场
         * fieldTeamManagerName : 姚有法
         * fieldUnitName : 二分队
         * fieldUnitManagerName : 刘波
         * workTeamName : 常营班
         * workTeamManagerName : 贾改子
         * companyType : 1
         * workCompanyId : 66db0055ee2d42a0910af02f1c56d068
         * companyName : 三队
         * segmentNo : 213123
         * streetSegment : 1412
         * minStreetStart : 41231
         * maxStreetEnd : 3123123131
         * belongStreet : 071d11eb469b4e2b9b8f0b159052d8c4
         * belongCommunity : 04b7bd2f635c4a9d8521dc376daac6ae
         * belongStreetName : 左家庄、麦子店
         * belongCommunityName : 常营地区
         * belongGrid : 123
         * orderNo : eqweq
         * simpleNo : qeqw
         * remark : qeqw
         * objectKey : 1131477高碑店地区 高碑店路九段 半壁店红路灯向北路东侧 高碑店村委会路东侧
         * streetLevelName : 一级
         * areaTypeName :
         * auditStatusName :
         * companyTypeName : 专业
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String markNo;
        private String branchesNo;
        private String streetName;
        private String streetLevel;
        private String streetStart;
        private String streetEnd;
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
        private String companyType;
        private String workCompanyId;
        private String companyName;
        private String segmentNo;
        private String streetSegment;
        private String minStreetStart;
        private String maxStreetEnd;
        private String belongStreet;
        private String belongCommunity;
        private String belongStreetName;
        private String belongCommunityName;
        private String belongGrid;
        private String orderNo;
        private String simpleNo;
        private String remark;
        private String objectKey;
        private String streetLevelName;
        private String areaTypeName;
        private String auditStatusName;
        private String companyTypeName;

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

        public String getMarkNo() {
            return markNo;
        }

        public void setMarkNo(String markNo) {
            this.markNo = markNo;
        }

        public String getBranchesNo() {
            return branchesNo;
        }

        public void setBranchesNo(String branchesNo) {
            this.branchesNo = branchesNo;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getStreetLevel() {
            return streetLevel;
        }

        public void setStreetLevel(String streetLevel) {
            this.streetLevel = streetLevel;
        }

        public String getStreetStart() {
            return streetStart;
        }

        public void setStreetStart(String streetStart) {
            this.streetStart = streetStart;
        }

        public String getStreetEnd() {
            return streetEnd;
        }

        public void setStreetEnd(String streetEnd) {
            this.streetEnd = streetEnd;
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

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
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

        public String getSegmentNo() {
            return segmentNo;
        }

        public void setSegmentNo(String segmentNo) {
            this.segmentNo = segmentNo;
        }

        public String getStreetSegment() {
            return streetSegment;
        }

        public void setStreetSegment(String streetSegment) {
            this.streetSegment = streetSegment;
        }

        public String getMinStreetStart() {
            return minStreetStart;
        }

        public void setMinStreetStart(String minStreetStart) {
            this.minStreetStart = minStreetStart;
        }

        public String getMaxStreetEnd() {
            return maxStreetEnd;
        }

        public void setMaxStreetEnd(String maxStreetEnd) {
            this.maxStreetEnd = maxStreetEnd;
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

        public String getBelongGrid() {
            return belongGrid;
        }

        public void setBelongGrid(String belongGrid) {
            this.belongGrid = belongGrid;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getSimpleNo() {
            return simpleNo;
        }

        public void setSimpleNo(String simpleNo) {
            this.simpleNo = simpleNo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getObjectKey() {
            return objectKey;
        }

        public void setObjectKey(String objectKey) {
            this.objectKey = objectKey;
        }

        public String getStreetLevelName() {
            return streetLevelName;
        }

        public void setStreetLevelName(String streetLevelName) {
            this.streetLevelName = streetLevelName;
        }

        public String getAreaTypeName() {
            return areaTypeName;
        }

        public void setAreaTypeName(String areaTypeName) {
            this.areaTypeName = areaTypeName;
        }

        public String getAuditStatusName() {
            return auditStatusName;
        }

        public void setAuditStatusName(String auditStatusName) {
            this.auditStatusName = auditStatusName;
        }

        public String getCompanyTypeName() {
            return companyTypeName;
        }

        public void setCompanyTypeName(String companyTypeName) {
            this.companyTypeName = companyTypeName;
        }
    }
}
