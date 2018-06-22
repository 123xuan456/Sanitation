package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/1/31.
 */

public class WorkCompanyBean  implements Serializable {

    /**
     * result : 1
     * msg : 获取成功
     * infos : [{"id":"66db0055ee2d42a0910af02f1c56d068","isNewRecord":false,"createDate":"2018-01-04 11:11:31","updateDate":"2018-01-04 11:11:31","name":"三队","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"三队"},{"id":"d3245c5753804fd780b4e34ede0bfe67","isNewRecord":false,"createDate":"2018-01-03 17:46:04","updateDate":"2018-01-03 17:46:08","name":"天翌物业管理有限责任公司","address":"朝阳区","belongUnit":"567fcbdb76b5405f8455480845c66d79","belongUnitName":"四队","simpleName":"天翌"},{"id":"670e77662ebd423b937f4c70d739284b","isNewRecord":false,"createDate":"2018-01-03 17:39:35","updateDate":"2018-01-03 17:39:35","name":"北京市东风洁洁保洁服务中心","address":"朝阳区","belongUnit":"4","belongUnitName":"二队","simpleName":"东风"},{"id":"ee4429f8c6bd4a3aa0d6238a1cae1a39","isNewRecord":false,"createDate":"2018-01-03 17:09:31","updateDate":"2018-01-03 17:09:31","name":"北京市朝坝服务中心","address":"朝阳区","belongUnit":"6","belongUnitName":"一队","simpleName":"朝坝"},{"id":"a28fb71912cd4f6fb0d7019cfa7f17ae","isNewRecord":false,"createDate":"2018-01-03 17:02:57","updateDate":"2018-01-03 17:02:57","name":"北京首创环境投资有限公司","address":"朝阳区","belongUnit":"8a2ef26761244be98ada97b526439495","belongUnitName":"环卫服务中心首创","simpleName":"首创"},{"id":"ae203f7a0ea74b86989e4b778f0352b4","isNewRecord":false,"createDate":"2018-01-03 17:02:27","updateDate":"2018-01-03 17:02:27","name":"北京环境卫生工程集团有限公司","address":"朝阳区","belongUnit":"8ab958a9beaa423fbab17ed89ab3f8de","belongUnitName":"环卫服务中心北清","simpleName":"北清"},{"id":"98ce09fa2b5f4e01a616b1c509c0639d","isNewRecord":false,"createDate":"2017-11-29 18:28:44","updateDate":"2017-11-29 18:28:44","name":"北京市朝阳区酒仙桥街道社区服务中心","address":"朝阳区","belongUnit":"4","belongUnitName":"二队","simpleName":"酒仙桥"},{"id":"429420d883d44bfeb8edeabf1f8e9b8b","isNewRecord":false,"createDate":"2017-11-29 18:02:10","updateDate":"2017-11-29 18:02:10","name":"北京蓝景保洁有限公司","address":"朝阳区","belongUnit":"6","belongUnitName":"一队","simpleName":"蓝景"},{"id":"b72ceed6daa749a390588fc5c01a8b17","isNewRecord":false,"createDate":"2017-11-29 17:39:49","updateDate":"2017-11-29 17:39:49","name":"北京望京新兴产业区综合开发有限公司","address":"朝阳区","belongUnit":"3","belongUnitName":"四场","simpleName":"望京"},{"id":"b34c2097fbe24ec2972de3b5939b0230","isNewRecord":false,"createDate":"2017-11-29 17:38:41","updateDate":"2017-11-29 17:38:41","name":"北京朝阳将台服务中心","address":"朝阳区","belongUnit":"4","belongUnitName":"二队","simpleName":"将台"},{"id":"7472d507476c4c03b7a6e2748390feea","isNewRecord":false,"createDate":"2017-11-29 17:36:42","updateDate":"2017-11-29 17:36:42","name":"北京大洋路商业管理中心","address":"朝阳区","belongUnit":"567fcbdb76b5405f8455480845c66d79","belongUnitName":"四队","simpleName":"大洋"},{"id":"b1d5dc5c0e5a427395cb2623a98a4144","isNewRecord":false,"createDate":"2017-11-29 17:36:39","updateDate":"2017-11-29 17:36:39","name":"北京市朝来兴盛保洁有限公司","address":"朝阳区","belongUnit":"3","belongUnitName":"四场","simpleName":"朝来"},{"id":"fb3b126748084c98ad00d853928fb9f4","isNewRecord":false,"createDate":"2017-11-29 15:52:29","updateDate":"2017-11-29 15:52:29","name":"专业","address":"朝阳区","belongUnit":"","simpleName":"专业"},{"id":"4b7556bbac0941139e2b2b490ce9d8d5","isNewRecord":false,"createDate":"2017-11-29 10:30:13","updateDate":"2017-11-29 10:30:13","name":"北京环业兴吉科技有限公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"环兴"},{"id":"74c44c4914b5472d82856e63f4d7a171","isNewRecord":false,"createDate":"2017-11-29 10:30:10","updateDate":"2017-11-29 10:30:10","name":"北京博宇嘉物业管理有限公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"博宇"},{"id":"8332580ba2ea45d88f0a789a3c0ae447","isNewRecord":false,"createDate":"2017-11-29 10:29:58","updateDate":"2017-11-29 10:29:58","name":"北京新畅保洁服务有限公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"新畅"},{"id":"7accfb9b47024ee6a8ca55e5750a1517","isNewRecord":false,"createDate":"2017-11-29 10:29:53","updateDate":"2017-11-29 10:29:53","name":"北京同利源耕农业环保技术有限公","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"同利"},{"id":"18e5a2dbd2054f70990832d3bab49397","isNewRecord":false,"createDate":"2017-11-29 10:29:51","updateDate":"2017-11-29 10:29:51","name":"北京易坤科技发展有限公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"易坤"},{"id":"d3245c5753804fd780b4e34ede0bfe66","isNewRecord":false,"createDate":"2017-11-29 10:29:49","updateDate":"2017-11-29 10:29:49","name":"北京市马各庄物业管理中心","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"马各庄"},{"id":"7326544315eb4085a4ea531749072640","isNewRecord":false,"createDate":"2017-11-29 10:29:38","updateDate":"2017-11-29 10:29:38","name":"北京世纪凯丰环境科技有限公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"凯丰"},{"id":"2a9a8b0e422345c6b5c5f4ca60b53b59","isNewRecord":false,"createDate":"2017-11-29 10:29:29","updateDate":"2017-11-29 10:29:29","name":"北京市满天星劳务派遣中心","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"满天星"},{"id":"2c256621fb6343d58331bca97f08dc95","isNewRecord":false,"createDate":"2017-11-29 10:29:29","updateDate":"2017-11-29 10:29:29","name":"北京盛世四合商贸有限公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"盛世"},{"id":"0e1648c5834f43e29f551973aa248a6f","isNewRecord":false,"createDate":"2017-11-29 10:29:28","updateDate":"2017-11-29 10:29:28","name":"北京熇飞翔保洁服务公司","address":"朝阳区","belongUnit":"2","belongUnitName":"朝环三队","simpleName":"熇飞"}]
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

    public static class InfosBean  implements Serializable{
        /**
         * id : 66db0055ee2d42a0910af02f1c56d068
         * isNewRecord : false
         * createDate : 2018-01-04 11:11:31
         * updateDate : 2018-01-04 11:11:31
         * name : 三队
         * address : 朝阳区
         * belongUnit : 2
         * belongUnitName : 朝环三队
         * simpleName : 三队
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String name;
        private String address;
        private String belongUnit;
        private String belongUnitName;
        private String simpleName;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBelongUnit() {
            return belongUnit;
        }

        public void setBelongUnit(String belongUnit) {
            this.belongUnit = belongUnit;
        }

        public String getBelongUnitName() {
            return belongUnitName;
        }

        public void setBelongUnitName(String belongUnitName) {
            this.belongUnitName = belongUnitName;
        }

        public String getSimpleName() {
            return simpleName;
        }

        public void setSimpleName(String simpleName) {
            this.simpleName = simpleName;
        }
    }
}
