package com.imooc.lp.newlambda;

public interface UserPredicate {
    /**
     * 判断标准
     * @param user
     * @return
     */
    boolean test(User user);
}
