package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/3/6.
 */

public class CaseProcessListBean implements Serializable {
    /**
     * result : 1
     * msg : 获取成功
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

    public static class InfosBean implements Serializable {
        /**
         * id : c4e57477d22549bb8caf67fef4afa1a9
         * isNewRecord : false
         * createDate : 2018-01-16 11:04:44
         * updateDate : 2018-01-16 11:04:44
         * caseGridId : 3a00dcde26aa4003bd9fcb15ff6f2416
         * dealUser : 系统管理员
         * dealUserName : 系统管理员
         * process : 改派案件
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String caseGridId;
        private String dealUser;
        private String dealUserName;
        private String process;

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

        public String getCaseGridId() {
            return caseGridId;
        }

        public void setCaseGridId(String caseGridId) {
            this.caseGridId = caseGridId;
        }

        public String getDealUser() {
            return dealUser;
        }

        public void setDealUser(String dealUser) {
            this.dealUser = dealUser;
        }

        public String getDealUserName() {
            return dealUserName;
        }

        public void setDealUserName(String dealUserName) {
            this.dealUserName = dealUserName;
        }

        public String getProcess() {
            return process;
        }

        public void setProcess(String process) {
            this.process = process;
        }
    }
}
