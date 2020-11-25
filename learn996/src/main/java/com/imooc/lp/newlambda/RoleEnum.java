package com.imooc.lp.newlambda;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum RoleEnum {

    MO_BSS_ADM(1, "运营管理员"),
    VDC_ADM(2, "VDC管理员"),
    VDC_READONLY(3, "VDC只读管理员"),
    VDC_USER(4, "VDC业务员");

    private Integer code;

    private String name;
}
