package com.imooc.lp.newlambda;

public class UserEnabledPredicate implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getEnabled() == true;
    }
}
