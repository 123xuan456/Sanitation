package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/1/30.
 */

public class RubbishListBean implements Serializable {


    /**
     * result : 1
     * msg : 获取成功！
     * infos : [{"id":"889527b4e0ad48bcbd99e4318eb7e904","isNewRecord":false,"createDate":"2018-06-15 16:18:51","updateDate":"2018-06-15 16:40:35","markNo":"999998898","rubbishName":"8989008","rubbishNo":"8889989","propertyRight":"1","leader":"a5c16e10e84c4c7db2f000063f5fe824","fieldTeam":"3","fieldTeamManager":"cf2961e5a43d4cbaa061ca9433410829","fieldUnit":"d15c0b745d634f90b2038c983ab4c83e","fieldUnitManager":"37c65bdc4a244d84b980c2e564f4fcf7","workTeam":"48a427347b214130863d4e52c840ca46","workTeamManager":"60b52f243ab54eaebbc1b37e15c0452b","leaderName":"关鹏","fieldTeamName":"四场","fieldTeamManagerName":"姚有法","fieldUnitName":"二分队","fieldUnitManagerName":"刘波","workTeamName":"常营班","workTeamManagerName":"贾改子","selfCheck":"87","workCompanyId":"66db0055ee2d42a0910af02f1c56d068","companyName":"三队","belongStreet":"071d11eb469b4e2b9b8f0b159052d8c4","belongCommunity":"045e91b1bafb4ea19a8ccf33b5acac3d","belongStreetName":"左家庄、麦子店","belongCommunityName":"金台社区","belongGrid":"77787","photoa":"|/message/envirRubbish/2018-06-15/1529050730450/23cba00c9b2843a0a4eee98884417ccb.png","photob":"|/message/envirRubbish/2018-06-15/1529050730439/6e08822555b247d28b583c9a3af77d23.png|/message/envirRubbish/2018-06-15/1529050730443/be5c77f039c940858974e44c2a0c5dd0.png|/message/envirRubbish/2018-06-15/1529050730446/9f9633ab99ea4d25a11b9dbacb80e0b0.png","auditStatus":"3","auditReason":"","remark":"877","baseId":"8bcd14db8dd94c6bb0c76318067b3a0c","objectKey":"1126863机场街道 南平里社区 机场体育场西","propertyRightName":"朝阳区环卫中心","auditStatusName":"审核完成","areaTypeName":""},{"id":"7768c7e8b4b24f0ea5b712be82bfadfc","isNewRecord":false,"createDate":"2018-06-15 16:18:50","updateDate":"2018-06-15 16:18:50","markNo":"白天睡觉","rubbishName":"吖我在想","rubbishNo":"噢耶稣","type":"","rubbishClass":"","address":"","propertyRight":"1","leader":"a5c16e10e84c4c7db2f000063f5fe824","fieldTeam":"2","fieldTeamManager":"c4b0d3a3a0f447eaa90d2016ced56716","leaderName":"关鹏","fieldTeamName":"朝环三队","fieldTeamManagerName":"王月玲","selfCheck":"","workCompanyId":"ae203f7a0ea74b86989e4b778f0352b4","companyName":"北京环境卫生工程集团有限公司","belongStreet":"071d11eb469b4e2b9b8f0b159052d8c4","belongCommunity":"503d77a36afb42d8a389ab1a9400b4fb","belongStreetName":"左家庄、麦子店","belongCommunityName":"小红门地区","belongGrid":"be","photoa":"|/message/envirRubbish/2018-06-15/1529050730159/239499cceffa432cb52b745a00991a86.jpg","photob":"|/message/envirRubbish/2018-06-15/1529050730131/4c5919c81a0440e79e2da20c96e8959d.jpg|/message/envirRubbish/2018-06-15/1529050730155/328bf477db804d05b6af72e762cd1846.png","auditStatus":"","auditReason":"","remark":"白天睡觉","baseId":"766a3ae21e4e42219ea5db0fa5204330","objectKey":"1126701管庄地区 司辛庄村 司辛庄村","propertyRightName":"朝阳区环卫中心","auditStatusName":"","areaTypeName":""}]
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
         * id : 889527b4e0ad48bcbd99e4318eb7e904
         * isNewRecord : false
         * createDate : 2018-06-15 16:18:51
         * updateDate : 2018-06-15 16:40:35
         * markNo : 999998898
         * rubbishName : 8989008
         * rubbishNo : 8889989
         * propertyRight : 1
         * leader : a5c16e10e84c4c7db2f000063f5fe824
         * fieldTeam : 3
         * fieldTeamManager : cf2961e5a43d4cbaa061ca9433410829
         * fieldUnit : d15c0b745d634f90b2038c983ab4c83e
         * fieldUnitManager : 37c65bdc4a244d84b980c2e564f4fcf7
         * workTeam : 48a427347b214130863d4e52c840ca46
         * workTeamManager : 60b52f243ab54eaebbc1b37e15c0452b
         * leaderName : 关鹏
         * fieldTeamName : 四场
         * fieldTeamManagerName : 姚有法
         * fieldUnitName : 二分队
         * fieldUnitManagerName : 刘波
         * workTeamName : 常营班
         * workTeamManagerName : 贾改子
         * selfCheck : 87
         * workCompanyId : 66db0055ee2d42a0910af02f1c56d068
         * companyName : 三队
         * belongStreet : 071d11eb469b4e2b9b8f0b159052d8c4
         * belongCommunity : 045e91b1bafb4ea19a8ccf33b5acac3d
         * belongStreetName : 左家庄、麦子店
         * belongCommunityName : 金台社区
         * belongGrid : 77787
         * photoa : |/message/envirRubbish/2018-06-15/1529050730450/23cba00c9b2843a0a4eee98884417ccb.png
         * photob : |/message/envirRubbish/2018-06-15/1529050730439/6e08822555b247d28b583c9a3af77d23.png|/message/envirRubbish/2018-06-15/1529050730443/be5c77f039c940858974e44c2a0c5dd0.png|/message/envirRubbish/2018-06-15/1529050730446/9f9633ab99ea4d25a11b9dbacb80e0b0.png
         * auditStatus : 3
         * auditReason :
         * remark : 877
         * baseId : 8bcd14db8dd94c6bb0c76318067b3a0c
         * objectKey : 1126863机场街道 南平里社区 机场体育场西
         * propertyRightName : 朝阳区环卫中心
         * auditStatusName : 审核完成
         * areaTypeName :
         * type :
         * rubbishClass :
         * address :
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String markNo;
        private String rubbishName;
        private String rubbishNo;
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
        private String belongStreet;
        private String belongCommunity;
        private String belongStreetName;
        private String belongCommunityName;
        private String belongGrid;
        private String photoa;
        private String photob;
        private String auditStatus;
        private String auditReason;
        private String remark;
        private String baseId;
        private String objectKey;
        private String propertyRightName;
        private String auditStatusName;
        private String areaTypeName;
        private String type;
        private String rubbishClass;
        private String address;

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
    }
}
