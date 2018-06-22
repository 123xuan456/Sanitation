package com.reeching.sanitation.app.bean;

import java.io.Serializable;

/**
 * Created by 绍轩 on 2018/6/8.
 */

public class BannerBean implements Serializable{
    /**
     * result : 1
     * msg : 获取成功！
     * infos : {"id":"b8b79808af3a4b4ca3086cc9454cd5fa","isNewRecord":false,"createDate":"2018-04-25 18:05:27","updateDate":"2018-04-25 18:16:44","photo":"/envir/userfiles/1/images/photo/2018/04/22.jpg"}
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
         * id : b8b79808af3a4b4ca3086cc9454cd5fa
         * isNewRecord : false
         * createDate : 2018-04-25 18:05:27
         * updateDate : 2018-04-25 18:16:44
         * photo : /envir/userfiles/1/images/photo/2018/04/22.jpg
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String photo;

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

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
