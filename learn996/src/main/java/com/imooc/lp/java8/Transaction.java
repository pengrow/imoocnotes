package com.imooc.lp.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    //交易员
    private Trader trader;
    //交易日期
    private int year;
    //交易金额
    private int value;

}
