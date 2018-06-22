package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/1/27.
 */

public class LeaderBean implements Serializable{

    /**
     * result : 1
     * msg : 获取成功
     * infos : [{"isParent":true,"name":"北京朝阳区","pId":"0","id":"1","pIds":"0,"},{"name":"关鹏","pId":"1","id":"a5c16e10e84c4c7db2f000063f5fe824","pIds":"0,1,"},{"name":"刘小亮","pId":"1","id":"4ae526e6380e46559c00b9a8e315d4a1","pIds":"0,1,"},{"name":"刘晓勇","pId":"1","id":"b65f61de75954379a78a30620a4d1a6a","pIds":"0,1,"},{"name":"李晶","pId":"1","id":"6","pIds":"0,1,"},{"name":"杜永旭","pId":"1","id":"1503aded22a8443abf9c2fb659867dd6","pIds":"0,1,"},{"name":"盛志毅","pId":"1","id":"e86e65fb7b184448b3fe1108ac67a416","pIds":"0,1,"},{"name":"系统管理员","pId":"1","id":"1","pIds":"0,1,"},{"name":"赵振兵","pId":"1","id":"a092ca9b225b405a9ffebcd7a0a6a3c0","pIds":"0,1,"}]
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
         * isParent : true
         * name : 北京朝阳区
         * pId : 0
         * id : 1
         * pIds : 0,
         */

        private boolean isParent;
        private String name;
        private String pId;
        private String id;
        private String pIds;

        public boolean isIsParent() {
            return isParent;
        }

        public void setIsParent(boolean isParent) {
            this.isParent = isParent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPId() {
            return pId;
        }

        public void setPId(String pId) {
            this.pId = pId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPIds() {
            return pIds;
        }

        public void setPIds(String pIds) {
            this.pIds = pIds;
        }
    }
}
