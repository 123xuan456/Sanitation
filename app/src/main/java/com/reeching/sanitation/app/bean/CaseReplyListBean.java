package com.reeching.sanitation.app.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 绍轩 on 2018/3/3.
 */

public class CaseReplyListBean implements Serializable {


    /**
     * result : 1
     * msg : 获取成功
     * infos : [{"id":"46b51b558ffa447099c6491260ee0487","isNewRecord":false,"createDate":"2018-03-05 14:12:16","updateDate":"2018-03-05 14:12:16","caseGridId":"2c3e86291c284d87bdb9a682ef902ffe","replyContent":"555","department":"d15c0b745d634f90b2038c983ab4c83e","user":{"id":"37c65bdc4a244d84b980c2e564f4fcf7","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"name":"刘波"},{"id":"7b2eb7ffc684451aacc0e5219faa5ded","isNewRecord":false,"createDate":"2018-03-05 13:58:46","updateDate":"2018-03-05 13:58:46","caseGridId":"2c3e86291c284d87bdb9a682ef902ffe","replyContent":"非我权属，fdasfda","department":"d15c0b745d634f90b2038c983ab4c83e","user":{"id":"37c65bdc4a244d84b980c2e564f4fcf7","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""},"name":"刘波"},{"id":"8eb439acaa364f44b17b2a9f25aae2fc","isNewRecord":false,"createDate":"2018-01-19 16:50:57","updateDate":"2018-01-19 16:50:57","caseGridId":"4c8cdeebaecc4f8aaf84a4aeddffa3f6","replyContent":"fdsaf","department":"1","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"},{"id":"55eb570e42b3456cb06535b4ab0685e3","isNewRecord":false,"createDate":"2018-01-02 10:20:51","updateDate":"2018-01-02 10:20:51","caseGridId":"3a00dcde26aa4003bd9fcb15ff6f2416","replyContent":"非我权属","department":"2","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"},{"id":"6f9bc2afa95e48bb93dfe9a955bd485e","isNewRecord":false,"createDate":"2017-12-11 15:30:34","updateDate":"2017-12-11 15:30:34","caseGridId":"3a00dcde26aa4004bd9fcb15ff6f2426","replyContent":"案件处理完成","department":"2","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"},{"id":"4cbd878688794c0c8d51888014fd4de6","isNewRecord":false,"createDate":"2017-12-04 18:58:19","updateDate":"2017-12-04 18:58:19","caseGridId":"3a00dcde26aa4004bd9fcb15ff6f2426","replyContent":"非我权属","department":"2","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"},{"id":"44aa9d96a2eb4ab5bf873e54d672c90b","isNewRecord":false,"createDate":"2017-12-04 18:44:50","updateDate":"2017-12-04 18:44:50","caseGridId":"3a00dcde26aa4004bd9fcb15ff6f2426","replyContent":"非我权属，","department":"2","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"},{"id":"ff61cc0efb5f43d3aae70191c9fc5160","isNewRecord":false,"createDate":"2017-12-04 18:44:15","updateDate":"2017-12-04 18:44:15","caseGridId":"3a00dcde26aa4004bd9fcb15ff6f2426","replyContent":"非我权属，","department":"2","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"},{"id":"071bfa9d368f4ac5b0d85a437cc2ecb2","isNewRecord":false,"createDate":"2017-11-30 18:36:20","updateDate":"2017-11-30 18:36:20","caseGridId":"4be27dc4001042498e6e8d7f57212965","replyContent":"sdfs","department":"2","user":{"id":"1","isNewRecord":false,"loginFlag":"1","admin":true,"roleNames":""},"name":"系统管理员"}]
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
         * id : 46b51b558ffa447099c6491260ee0487
         * isNewRecord : false
         * createDate : 2018-03-05 14:12:16
         * updateDate : 2018-03-05 14:12:16
         * caseGridId : 2c3e86291c284d87bdb9a682ef902ffe
         * replyContent : 555
         * department : d15c0b745d634f90b2038c983ab4c83e
         * user : {"id":"37c65bdc4a244d84b980c2e564f4fcf7","isNewRecord":false,"loginFlag":"1","admin":false,"roleNames":""}
         * name : 刘波
         */

        private String id;
        private boolean isNewRecord;
        private String createDate;
        private String updateDate;
        private String caseGridId;
        private String replyContent;
        private String department;
        private UserBean user;
        private String name;

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

        public String getReplyContent() {
            return replyContent;
        }

        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class UserBean {
            /**
             * id : 37c65bdc4a244d84b980c2e564f4fcf7
             * isNewRecord : false
             * loginFlag : 1
             * admin : false
             * roleNames :
             */

            private String id;
            private boolean isNewRecord;
            private String loginFlag;
            private boolean admin;
            private String roleNames;

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

            public String getLoginFlag() {
                return loginFlag;
            }

            public void setLoginFlag(String loginFlag) {
                this.loginFlag = loginFlag;
            }

            public boolean isAdmin() {
                return admin;
            }

            public void setAdmin(boolean admin) {
                this.admin = admin;
            }

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }
        }
    }
}
