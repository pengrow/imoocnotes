package com.imooc.lp.lambda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {

    // 购物车里的商品列表
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(2020001, "无人机", 999.00, 1, 999.00, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(2020002, "T-shirt", 50.00, 2, 100.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(2020003, "人生的枷锁", 30.00, 1, 30.00, SkuCategoryEnum.BOOKS));
            add(new Sku(2020004, "老人与海", 20.00, 1, 20.00, SkuCategoryEnum.BOOKS));
            add(new Sku(2020005, "剑指高效编程", 288.00, 1, 288.00, SkuCategoryEnum.BOOKS));
            add(new Sku(2020006, "大头皮鞋", 300.00, 1, 300.00, SkuCategoryEnum.CLOTHING));
            add(new Sku(2020007, "杠铃", 2000.00, 1, 2000.00, SkuCategoryEnum.SPORTS));
            add(new Sku(2020008, "ThinkPad", 5000.00, 1, 5000.00, SkuCategoryEnum.ELECTRONICS));
        }
    };

    /**
     * 获取购物车列表
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * version 1.0.0
     * 找出购物车里的所有电子产品
     *
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {
        List<Sku> result = new ArrayList<>();

        for (Sku sku : cartSkuList) {
            if (sku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS)) {
                result.add(sku);
            }
        }

        return result;

    }

    /**
     * v2.0.0
     * 根据传入的商品类型参数，找出购物车中同种商品类型的商品列表
     * @param cartSkuList
     * @param categoryEnum
     * @return
     */
    public static List<Sku> filterSkusByCategory(List<Sku> cartSkuList, SkuCategoryEnum categoryEnum) {
        List<Sku> result = new ArrayList<>();

        for (Sku sku : cartSkuList) {
            if (sku.getSkuCategory().equals(categoryEnum)) {
                result.add(sku);
            }
        }

        return result;
    }

    /**
     * version 3.0.0
     * 支持通过商品类型或总价来过滤商品
     * @param cartSkuList
     * @param categoryEnum
     * @param totalPrice
     * @param categroyOrPrice true:根据商品类型, false:根据商品总价
     * @return
     */
    public static List<Sku> filterSkus(List<Sku> cartSkuList, SkuCategoryEnum categoryEnum, Double totalPrice, Boolean categroyOrPrice) {
        List<Sku> result = new ArrayList<>();

        for (Sku sku : cartSkuList) {
            if ((categroyOrPrice && sku.getSkuCategory().equals(categoryEnum))
                    || (!categroyOrPrice && sku.getTotalPrice() > totalPrice)) {
                result.add(sku);
            }
        }

        return result;
    }

}
