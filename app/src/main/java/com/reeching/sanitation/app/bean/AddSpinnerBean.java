package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/3/8.
 */

public class AddSpinnerBean implements Serializable {
    /**
     * result : 1
     * msg : 获取成功！
     * infos : [{"id":"7c9fb39371ef4a6d9e09b56635dd630a","isNewRecord":false,"remarks":"","createDate":"2018-01-03 15:38:25","updateDate":"2018-01-03 15:38:25","value":"1","label":"城区","type":"area_type","description":"区域","sort":10,"parentId":"0"},{"id":"25462dac793f432486a3222e8bf4f270","isNewRecord":false,"remarks":"","createDate":"2018-01-03 15:38:49","updateDate":"2018-01-03 15:38:49","value":"2","label":"地区","type":"area_type","description":"区域","sort":20,"parentId":"0"}]
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
         * id : 7c9fb39371ef4a6d9e09b56635dd630a
         * isNewRecord : false
         * remarks :
         * createDate : 2018-01-03 15:38:25
         * updateDate : 2018-01-03 15:38:25
         * value : 1
         * label : 城区
         * type : area_type
         * description : 区域
         * sort : 10
         * parentId : 0
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String value;
        private String label;
        private String type;
        private String description;
        private int sort;
        private String parentId;

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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
    }
}
