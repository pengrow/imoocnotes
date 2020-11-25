package com.imooc.lp.newlambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 下单商品信息对象
 */
@Data
@AllArgsConstructor
public class Sku {

    private Integer skuId;

    private String skuName;

    private Double skuPrice;

    private Integer totalNum;

    private Double totalPrice;

    private Enum skuCategory;
}
