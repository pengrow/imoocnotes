package com.imooc.lp.stream.cases;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class CaseThreeTest {


    @Data
    @AllArgsConstructor
    class Role {
        /**
         * 权限列表
         */
        private List<Permission> permissions;

        public List<Permission> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<Permission> permissions) {
            this.permissions = permissions;
        }
    }

    @Data
    @AllArgsConstructor
    class Permission {
        private String name;
    }


}
