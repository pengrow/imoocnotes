package com.imooc.lp.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class Version1Test {

    @Test
    public void filterElectronicSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        //查找购物车中的数码类商品
        List<Sku> result = CartService.filterElectronicsSkus(cartSkuList);

        System.out.println(JSON.toJSONString(result, true));
    }
}
