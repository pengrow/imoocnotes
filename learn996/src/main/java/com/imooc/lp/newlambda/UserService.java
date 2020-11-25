package com.imooc.lp.newlambda;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<User> userList = new ArrayList<User>() {
        {
            add(new User("u001", "运营管理员-1", "", RoleEnum.MO_BSS_ADM, "d000", "mo_bss_admin", null, null, true));
            add(new User("u002", "运营管理员-2", "11111", RoleEnum.MO_BSS_ADM, "d000", "mo_bss_admin", null, null, false));
            add(new User("u003", "VDC管理员-1", "1231 ", RoleEnum.VDC_ADM, "d001", "domain1", "v001", "vdc1", true));
            add(new User("u004", "VDC管理员-2", "", RoleEnum.VDC_ADM, "d001", "domain1", "v001", "vdc1", true));
            add(new User("u005", "VDC管理员-3", "2342342", RoleEnum.VDC_ADM, "d001", "domain1", "v002", "vdc2", false));
            add(new User("u006", "VDC管理员-4", "", RoleEnum.VDC_ADM, "d002", "domain2", "v003", "vdc3", true));
            add(new User("u007", "VDC只读管理员-1", "", RoleEnum.VDC_READONLY, "d002", "domain2", "v004", "vdc4", true));
            add(new User("u008", "VDC管理员-5", "", RoleEnum.VDC_ADM, "d003", "domain3", "v005", "vdc5", true));
            add(new User("u009", "VDC业务员-1", "538045", RoleEnum.VDC_USER, "d003", "domain3", "v005", "vdc5", true));
            add(new User("u010", "VDC业务员-2", "456345", RoleEnum.VDC_USER, "d003", "domain3", "v005", "vdc5", true));
        }
    };

    public static List<User> getUserList() {
        return userList;
    }

    /**
     * 找出VDC管理员用户
     *
     * @param userList
     * @return
     */
    public static List<User> filterVdcAdminUsers(List<User> userList) {
        List<User> result = new ArrayList<>();

        for (User user : userList) {
            if (RoleEnum.VDC_ADM.equals(user.getRole())) {
                result.add(user);
            }
        }

        return result;
    }

    //根据角色过滤用户
    public static List<User> filterUsersByRole(List<User> userList, RoleEnum role) {
        List<User> result = new ArrayList<>();

        for (User user : userList) {
            if (role.equals(user.getRole())) {
                result.add(user);
            }
        }

        return result;
    }


    //根据角色过滤用户,同时支持enabled状态过滤

    /**
     * @param userList
     * @param role
     * @param enabled
     * @param roleOrEnabled true role, false enabled
     * @return
     */
    public static List<User> filterUsers(List<User> userList, RoleEnum role, Boolean enabled, Boolean roleOrEnabled) {
        List<User> result = new ArrayList<>();

        for (User user : userList) {

            if ((roleOrEnabled && role.equals(user.getRole())) || !roleOrEnabled && enabled.equals(user.getEnabled())) {
                result.add(user);
            }
        }

        return result;
    }

    //类似策略模型
    public static List<User> filterUsers(List<User> userList, UserPredicate userPredicate) {
        List<User> result = new ArrayList<>();

        for (User user : userList) {
            if (userPredicate.test(user)) {
                result.add(user);
            }
        }

        return result;
    }
}
