package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/1/30.
 */

public class StreetListBean  implements Serializable {


    /**
     * result : 1
     * msg : 获取成功！
     * infos : [{"id":"5bdcb35a7add4a43a340cb03f504fca3","isNewRecord":false,"createDate":"2018-06-15 16:00:33","updateDate":"2018-06-15 16:57:02","markNo":"12","branchesNo":"aa","streetName":"呃呃呃","streetLevel":"3","streetStart":"aa","streetEnd":"ABC","leader":"a5c16e10e84c4c7db2f000063f5fe824","fieldTeam":"4","fieldTeamManager":"5df316c0e9574733a243d0145196cc26","leaderName":"关鹏","fieldTeamName":"二队","fieldTeamManagerName":"冯明业","companyType":"2","workCompanyId":"ee4429f8c6bd4a3aa0d6238a1cae1a39","companyName":"北京市朝坝服务中心","segmentNo":"白","streetSegment":"锕","minStreetStart":"饿","maxStreetEnd":"啊","belongStreet":"19eb7906e0ff45849293a69f9f6e4d39","belongCommunity":"503d77a36afb42d8a389ab1a9400b4fb","belongStreetName":"高碑店、三间房、管庄、黑庄户","belongCommunityName":"小红门地区","belongGrid":"嗄","orderNo":"阿","simpleNo":"吖","areaType":"2","auditStatus":"2","remark":"白白\n","baseId":"ea596fed27914e12b94f547386b4a7a8","objectKey":"1131476高碑店地区 高碑店路八段 半壁店小学路口向北路东西两侧 半壁店红绿灯路东西两侧","streetLevelName":"三级","areaTypeName":"地区","auditStatusName":"审核中","companyTypeName":"委托"},{"id":"919db9b4ebab4b6fab646e5c55ea5971","isNewRecord":false,"createDate":"2018-06-15 16:00:31","updateDate":"2018-06-15 16:54:59","markNo":"3453","branchesNo":"456456","streetName":"7676","streetLevel":"1","streetStart":"00","streetEnd":"00","leader":"a5c16e10e84c4c7db2f000063f5fe824","fieldTeam":"3","fieldTeamManager":"cf2961e5a43d4cbaa061ca9433410829","fieldUnit":"d15c0b745d634f90b2038c983ab4c83e","fieldUnitManager":"37c65bdc4a244d84b980c2e564f4fcf7","workTeam":"48a427347b214130863d4e52c840ca46","workTeamManager":"60b52f243ab54eaebbc1b37e15c0452b","leaderName":"关鹏","fieldTeamName":"四场","fieldTeamManagerName":"姚有法","fieldUnitName":"二分队","fieldUnitManagerName":"刘波","workTeamName":"常营班","workTeamManagerName":"贾改子","companyType":"1","workCompanyId":"66db0055ee2d42a0910af02f1c56d068","companyName":"三队","segmentNo":"666","streetSegment":"66","minStreetStart":"66","maxStreetEnd":"6","belongStreet":"071d11eb469b4e2b9b8f0b159052d8c4","belongCommunity":"045e91b1bafb4ea19a8ccf33b5acac3d","belongStreetName":"左家庄、麦子店","belongCommunityName":"金台社区","belongGrid":"66776","orderNo":"76","simpleNo":"766","areaType":"1","auditStatus":"2","remark":"677666","baseId":"8bcd14db8dd94c6bb0c76318067b3a0c","objectKey":"1126863机场街道 南平里社区 机场体育场西","streetLevelName":"一级","areaTypeName":"城区","auditStatusName":"审核中","companyTypeName":"专业"}]
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
         * id : 5bdcb35a7add4a43a340cb03f504fca3
         * isNewRecord : false
         * createDate : 2018-06-15 16:00:33
         * updateDate : 2018-06-15 16:57:02
         * markNo : 12
         * branchesNo : aa
         * streetName : 呃呃呃
         * streetLevel : 3
         * streetStart : aa
         * streetEnd : ABC
         * leader : a5c16e10e84c4c7db2f000063f5fe824
         * fieldTeam : 4
         * fieldTeamManager : 5df316c0e9574733a243d0145196cc26
         * leaderName : 关鹏
         * fieldTeamName : 二队
         * fieldTeamManagerName : 冯明业
         * companyType : 2
         * workCompanyId : ee4429f8c6bd4a3aa0d6238a1cae1a39
         * companyName : 北京市朝坝服务中心
         * segmentNo : 白
         * streetSegment : 锕
         * minStreetStart : 饿
         * maxStreetEnd : 啊
         * belongStreet : 19eb7906e0ff45849293a69f9f6e4d39
         * belongCommunity : 503d77a36afb42d8a389ab1a9400b4fb
         * belongStreetName : 高碑店、三间房、管庄、黑庄户
         * belongCommunityName : 小红门地区
         * belongGrid : 嗄
         * orderNo : 阿
         * simpleNo : 吖
         * areaType : 2
         * auditStatus : 2
         * remark : 白白

         * baseId : ea596fed27914e12b94f547386b4a7a8
         * objectKey : 1131476高碑店地区 高碑店路八段 半壁店小学路口向北路东西两侧 半壁店红绿灯路东西两侧
         * streetLevelName : 三级
         * areaTypeName : 地区
         * auditStatusName : 审核中
         * companyTypeName : 委托
         * fieldUnit : d15c0b745d634f90b2038c983ab4c83e
         * fieldUnitManager : 37c65bdc4a244d84b980c2e564f4fcf7
         * workTeam : 48a427347b214130863d4e52c840ca46
         * workTeamManager : 60b52f243ab54eaebbc1b37e15c0452b
         * fieldUnitName : 二分队
         * fieldUnitManagerName : 刘波
         * workTeamName : 常营班
         * workTeamManagerName : 贾改子
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
        private String leaderName;
        private String fieldTeamName;
        private String fieldTeamManagerName;
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
        private String areaType;
        private String auditStatus;
        private String remark;
        private String baseId;
        private String objectKey;
        private String streetLevelName;
        private String areaTypeName;
        private String auditStatusName;
        private String companyTypeName;
        private String fieldUnit;
        private String fieldUnitManager;
        private String workTeam;
        private String workTeamManager;
        private String fieldUnitName;
        private String fieldUnitManagerName;
        private String workTeamName;
        private String workTeamManagerName;

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

        public String getAreaType() {
            return areaType;
        }

        public void setAreaType(String areaType) {
            this.areaType = areaType;
        }

        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getBaseId() {
            return baseId;
        }

        public void setBaseId(String baseId) {
            this.baseId = baseId;
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
    }
}
