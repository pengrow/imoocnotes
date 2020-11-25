package com.imooc.lp.newlambda;

public class UserVdcAdminRolePredicate implements UserPredicate {
    @Override
    public boolean test(User user) {
        return RoleEnum.VDC_ADM.equals(user.getRole());
    }
}
