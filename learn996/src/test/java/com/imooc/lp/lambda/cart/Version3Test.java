package com.imooc.lp.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version3Test {

    @Test
    public void filterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        //查找购物车中的商品的总价过滤超过2000元的商品列表
        List<Sku> result = CartService.filterSkus(cartSkuList, null, 2000.00, false );

        System.out.println(JSON.toJSONString(result, true));
    }
}
