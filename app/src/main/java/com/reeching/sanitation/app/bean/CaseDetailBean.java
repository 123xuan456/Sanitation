package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/3/5.
 */

public class CaseDetailBean implements Serializable {
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

    public static class InfosBean implements Serializable {
        /**
         * id : 2c3e86291c284d87bdb9a682ef902ffe
         * isNewRecord : false
         * remarks :
         * createDate : 2018-02-21 17:22:33
         * updateDate : 2018-03-05 14:12:16
         * caseDate : 2018-02-21 17:22:33
         * fileNumber :
         * pointName : 崔各庄地区 善各庄村 善各庄滨河路旁
         * blameUnit : 3
         * blameUnit1 : 四场
         * blameUnitName : 四场
         * accountNo : 刘波
         * workCompanyId : 18e5a2dbd2054f70990832d3bab49397
         * companyName : 北京易坤科技发展有限公司
         * workType : 200505
         * belongStreet : 0e38c0510b6143ad8de2a3b047da6bdc
         * belongStreetName : 东坝地区
         * caseArea :
         * isRed :
         * replyUnit :
         * belongNoMe : 1
         * nomeArea : 1
         * isBill : 1
         * gaipai : 1
         * gaipaiUnit :
         * dealPhoto :
         * questionPhoto : /envir/userfiles/1/images/questionPhoto/2017/12/fdafdsa.png|/envir/userfiles/1/images/questionPhoto/2017/12/fdafdsa.png|/envir/userfiles/1/images/questionPhoto/2017/12/fdafdsa.png
         * isRevoke :
         * caseState : 23
         * billState : 1
         * other :
         * isDaping : 1
         * checkCount :
         * remark :
         * fenduanName : 7
         * caseSource : 1
         * baseId : 0020ca0e8cc240d8981bd4665521127d
         * caseDesc : 7
         * taskdisposalDemandDeadline : 1519886500000
         * workTypeName : 公共厕所
         * caseStateName : 非我权属
         * companyName1 : 北京易坤科技发展有限公司
         * belongStreetName1 : 东坝地区
         * caseDesc1 : 7
         * caseArea1 :
         * belongNoMeId : 5f9efaec34054d28a3429179f69af4a9
         * belongNoMeName : 区绿化局
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String caseDate;
        private String fileNumber;
        private String pointName;
        private String blameUnit;
        private String blameUnit1;
        private String blameUnitName;
        private String accountNo;
        private String workCompanyId;
        private String companyName;
        private String workType;
        private String belongStreet;
        private String belongStreetName;
        private String caseArea;
        private String isRed;
        private String replyUnit;
        private String belongNoMe;
        private String nomeArea;
        private String isBill;
        private String gaipai;
        private String gaipaiUnit;
        private String dealPhoto;
        private String questionPhoto;
        private String isRevoke;
        private String caseState;
        private String billState;
        private String other;
        private String isDaping;
        private String checkCount;
        private String remark;
        private String fenduanName;
        private String caseSource;
        private String baseId;
        private String caseDesc;
        private long taskdisposalDemandDeadline;
        private String workTypeName;
        private String caseStateName;
        private String companyName1;
        private String belongStreetName1;
        private String caseDesc1;
        private String caseArea1;
        private String belongNoMeId;
        private String belongNoMeName;

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

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
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

        public String getCaseDate() {
            return caseDate;
        }

        public void setCaseDate(String caseDate) {
            this.caseDate = caseDate;
        }

        public String getFileNumber() {
            return fileNumber;
        }

        public void setFileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
        }

        public String getPointName() {
            return pointName;
        }

        public void setPointName(String pointName) {
            this.pointName = pointName;
        }

        public String getBlameUnit() {
            return blameUnit;
        }

        public void setBlameUnit(String blameUnit) {
            this.blameUnit = blameUnit;
        }

        public String getBlameUnit1() {
            return blameUnit1;
        }

        public void setBlameUnit1(String blameUnit1) {
            this.blameUnit1 = blameUnit1;
        }

        public String getBlameUnitName() {
            return blameUnitName;
        }

        public void setBlameUnitName(String blameUnitName) {
            this.blameUnitName = blameUnitName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
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

        public String getWorkType() {
            return workType;
        }

        public void setWorkType(String workType) {
            this.workType = workType;
        }

        public String getBelongStreet() {
            return belongStreet;
        }

        public void setBelongStreet(String belongStreet) {
            this.belongStreet = belongStreet;
        }

        public String getBelongStreetName() {
            return belongStreetName;
        }

        public void setBelongStreetName(String belongStreetName) {
            this.belongStreetName = belongStreetName;
        }

        public String getCaseArea() {
            return caseArea;
        }

        public void setCaseArea(String caseArea) {
            this.caseArea = caseArea;
        }

        public String getIsRed() {
            return isRed;
        }

        public void setIsRed(String isRed) {
            this.isRed = isRed;
        }

        public String getReplyUnit() {
            return replyUnit;
        }

        public void setReplyUnit(String replyUnit) {
            this.replyUnit = replyUnit;
        }

        public String getBelongNoMe() {
            return belongNoMe;
        }

        public void setBelongNoMe(String belongNoMe) {
            this.belongNoMe = belongNoMe;
        }

        public String getNomeArea() {
            return nomeArea;
        }

        public void setNomeArea(String nomeArea) {
            this.nomeArea = nomeArea;
        }

        public String getIsBill() {
            return isBill;
        }

        public void setIsBill(String isBill) {
            this.isBill = isBill;
        }

        public String getGaipai() {
            return gaipai;
        }

        public void setGaipai(String gaipai) {
            this.gaipai = gaipai;
        }

        public String getGaipaiUnit() {
            return gaipaiUnit;
        }

        public void setGaipaiUnit(String gaipaiUnit) {
            this.gaipaiUnit = gaipaiUnit;
        }

        public String getDealPhoto() {
            return dealPhoto;
        }

        public void setDealPhoto(String dealPhoto) {
            this.dealPhoto = dealPhoto;
        }

        public String getQuestionPhoto() {
            return questionPhoto;
        }

        public void setQuestionPhoto(String questionPhoto) {
            this.questionPhoto = questionPhoto;
        }

        public String getIsRevoke() {
            return isRevoke;
        }

        public void setIsRevoke(String isRevoke) {
            this.isRevoke = isRevoke;
        }

        public String getCaseState() {
            return caseState;
        }

        public void setCaseState(String caseState) {
            this.caseState = caseState;
        }

        public String getBillState() {
            return billState;
        }

        public void setBillState(String billState) {
            this.billState = billState;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getIsDaping() {
            return isDaping;
        }

        public void setIsDaping(String isDaping) {
            this.isDaping = isDaping;
        }

        public String getCheckCount() {
            return checkCount;
        }

        public void setCheckCount(String checkCount) {
            this.checkCount = checkCount;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getFenduanName() {
            return fenduanName;
        }

        public void setFenduanName(String fenduanName) {
            this.fenduanName = fenduanName;
        }

        public String getCaseSource() {
            return caseSource;
        }

        public void setCaseSource(String caseSource) {
            this.caseSource = caseSource;
        }

        public String getBaseId() {
            return baseId;
        }

        public void setBaseId(String baseId) {
            this.baseId = baseId;
        }

        public String getCaseDesc() {
            return caseDesc;
        }

        public void setCaseDesc(String caseDesc) {
            this.caseDesc = caseDesc;
        }

        public long getTaskdisposalDemandDeadline() {
            return taskdisposalDemandDeadline;
        }

        public void setTaskdisposalDemandDeadline(long taskdisposalDemandDeadline) {
            this.taskdisposalDemandDeadline = taskdisposalDemandDeadline;
        }

        public String getWorkTypeName() {
            return workTypeName;
        }

        public void setWorkTypeName(String workTypeName) {
            this.workTypeName = workTypeName;
        }

        public String getCaseStateName() {
            return caseStateName;
        }

        public void setCaseStateName(String caseStateName) {
            this.caseStateName = caseStateName;
        }

        public String getCompanyName1() {
            return companyName1;
        }

        public void setCompanyName1(String companyName1) {
            this.companyName1 = companyName1;
        }

        public String getBelongStreetName1() {
            return belongStreetName1;
        }

        public void setBelongStreetName1(String belongStreetName1) {
            this.belongStreetName1 = belongStreetName1;
        }

        public String getCaseDesc1() {
            return caseDesc1;
        }

        public void setCaseDesc1(String caseDesc1) {
            this.caseDesc1 = caseDesc1;
        }

        public String getCaseArea1() {
            return caseArea1;
        }

        public void setCaseArea1(String caseArea1) {
            this.caseArea1 = caseArea1;
        }

        public String getBelongNoMeId() {
            return belongNoMeId;
        }

        public void setBelongNoMeId(String belongNoMeId) {
            this.belongNoMeId = belongNoMeId;
        }

        public String getBelongNoMeName() {
            return belongNoMeName;
        }

        public void setBelongNoMeName(String belongNoMeName) {
            this.belongNoMeName = belongNoMeName;
        }
    }
}
