package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/3/14.
 */

public class WasteDetailBean implements Serializable {

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
         * id : 1b076e9c10984cb8846b809681399a35
         * isNewRecord : false
         * createDate : 2018-04-24 16:57:47
         * updateDate : 2018-04-24 16:57:47
         * markNo : 21312
         * rubbishName : 31231
         * rubbishNo : 42342
         * type :
         * rubbishClass :
         * address :
         * propertyRight : 1
         * leader : a5c16e10e84c4c7db2f000063f5fe824
         * fieldTeam : 6
         * fieldTeamManager : 1cce8f612c5a41459ff5bf399b59d1e0
         * fieldUnit : f7aa6883567240b4890a5b778a31cb5d
         * fieldUnitManager : 6d114a48a4094dd2b3af30ca3d067aa3
         * workTeam : 5b76b00376234215b94b00414e028fcd
         * workTeamManager : f30241bafe1f47fc8e238fed2cc522b8
         * leaderName : 关鹏
         * fieldTeamName : 一队
         * fieldTeamManagerName : 杨海池
         * fieldUnitName : 一分队
         * fieldUnitManagerName : 李玉茹
         * workTeamName : 使馆
         * workTeamManagerName : 张建娜
         * selfCheck : 12312
         * workCompanyId : 66db0055ee2d42a0910af02f1c56d068
         * companyName : 三队
         * belongGrid : 2
         * photoa : |/message/envirRubbish/2018-04-24/1524560266785/0e7baed3692c46d689f10fbdabe2b0db.png
         * photob : |/message/envirRubbish/2018-04-24/1524560266676/4718b3813a7a486ba575e1768ffb582e.jpg|/message/envirRubbish/2018-04-24/1524560266781/7be092d9a1ae4981853c56ca702ebfac.jpg
         * auditStatus :
         * auditReason :
         * remark : 21312
         * objectKey : 1126701管庄地区 司辛庄村 司辛庄村
         * propertyRightName : 朝阳区环卫中心
         * auditStatusName :
         * areaTypeName :
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String markNo;
        private String rubbishName;
        private String rubbishNo;
        private String type;
        private String rubbishClass;
        private String address;
        private String propertyRight;
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
        private String selfCheck;
        private String workCompanyId;
        private String companyName;
        private String belongGrid;
        private String photoa;
        private String photob;
        private String auditStatus;
        private String auditReason;
        private String remark;
        private String objectKey;
        private String propertyRightName;
        private String auditStatusName;
        private String areaTypeName;
        private String belongStreetName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getBelongStreetName() {
            return belongStreetName;
        }

        public void setBelongStreetName(String belongStreetName) {
            this.belongStreetName = belongStreetName;
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

        public String getRubbishName() {
            return rubbishName;
        }

        public void setRubbishName(String rubbishName) {
            this.rubbishName = rubbishName;
        }

        public String getRubbishNo() {
            return rubbishNo;
        }

        public void setRubbishNo(String rubbishNo) {
            this.rubbishNo = rubbishNo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRubbishClass() {
            return rubbishClass;
        }

        public void setRubbishClass(String rubbishClass) {
            this.rubbishClass = rubbishClass;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPropertyRight() {
            return propertyRight;
        }

        public void setPropertyRight(String propertyRight) {
            this.propertyRight = propertyRight;
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

        public String getSelfCheck() {
            return selfCheck;
        }

        public void setSelfCheck(String selfCheck) {
            this.selfCheck = selfCheck;
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

        public String getBelongGrid() {
            return belongGrid;
        }

        public void setBelongGrid(String belongGrid) {
            this.belongGrid = belongGrid;
        }

        public String getPhotoa() {
            return photoa;
        }

        public void setPhotoa(String photoa) {
            this.photoa = photoa;
        }

        public String getPhotob() {
            return photob;
        }

        public void setPhotob(String photob) {
            this.photob = photob;
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

        public String getPropertyRightName() {
            return propertyRightName;
        }

        public void setPropertyRightName(String propertyRightName) {
            this.propertyRightName = propertyRightName;
        }

        public String getAuditStatusName() {
            return auditStatusName;
        }

        public void setAuditStatusName(String auditStatusName) {
            this.auditStatusName = auditStatusName;
        }

        public String getAreaTypeName() {
            return areaTypeName;
        }

        public void setAreaTypeName(String areaTypeName) {
            this.areaTypeName = areaTypeName;
        }
    }
}
