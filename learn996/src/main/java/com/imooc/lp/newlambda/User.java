package com.imooc.lp.newlambda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String id;

    private String name;

    private String phoneNum;

    private Enum role;

    private String domainId;

    private String domainName;

    private String vdcId;

    private String vdcName;

    private Boolean enabled;

}
