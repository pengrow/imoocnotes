package com.imooc.lp.newlambda;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceTest {

    @Test
    public void test1() {
        List<User> users = UserService.getUserList();

        System.out.println(JSON.toJSONString(users, true));
    }


    @Test
    public void test2() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterVdcAdminUsers(users);

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test3() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterUsersByRole(users, RoleEnum.VDC_ADM);

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test4() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterUsers(users, RoleEnum.VDC_ADM, null, true);

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test5() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterUsers(users, null, false, false);

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test6() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterUsers(users, new UserEnabledPredicate());

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test7() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterUsers(users, new UserPredicate() {
            @Override
            public boolean test(User user) {
                return user.getEnabled() == true;
            }
        });

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test8() {
        List<User> users = UserService.getUserList();

        List<User> result = UserService.filterUsers(users, user -> user.getEnabled() == true && StringUtils.isNotEmpty(user.getPhoneNum()));

        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void test9() {
        List<User> users = UserService.getUserList();

        List<User> list = users.stream()
                .filter(u -> u.getEnabled() == true)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(list, true));
    }

    @Test
    public void test10() {
        List<User> users = UserService.getUserList();

        List<User> list = users.stream()
                .filter(u -> u.getEnabled() == true)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(list, true));
    }


    @Test
    public void test11() {
        List<User> users = UserService.getUserList();

        List<String> userNames = users.stream()
                .filter(u -> u.getEnabled() == true)
                .map(u -> u.getName())
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(userNames, true));
    }
}
